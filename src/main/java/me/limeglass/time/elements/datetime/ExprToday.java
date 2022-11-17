package me.limeglass.time.elements.datetime;

import java.util.TimeZone;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;

@Name("Today")
@Description("Returns todays date with optional specified timezones.")
@Examples("set {_today} to todays date")
@Since("1.0.0")
public class ExprToday extends SimpleExpression<DateTime> {

	static {
		Skript.registerExpression(ExprToday.class, DateTime.class, ExpressionType.COMBINED, "today[s date] [with time[ ]zone[s] %-strings/timezones%]");
	}

	@Nullable
	private Expression<?> timezones;

	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		timezones = exprs[0];
		return true;
	}

	@Override
	protected DateTime[] get(Event event) {
		if (timezones == null)
			return CollectionUtils.array(new DateTime());
		return timezones.stream(event).map(object -> {
				if (object instanceof TimeZone)
					return new DateTime(DateTimeZone.forTimeZone((TimeZone) object));
				return new DateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone((String) object)));
			}).toArray(DateTime[]::new);
	}

	@Override
	public boolean isSingle() {
		return timezones.isSingle();
	}

	@Override
	public Class<? extends DateTime> getReturnType() {
		return DateTime.class;
	}

	@Override
	public String toString(@Nullable Event event, boolean debug) {
		return "todays date";
	}

}
