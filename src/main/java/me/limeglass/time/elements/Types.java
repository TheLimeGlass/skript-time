package me.limeglass.time.elements;

import java.util.TimeZone;

import org.joda.time.DateTime;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.registrations.Classes;

public class Types {

	static {
		Classes.registerClass(new ClassInfo<>(DateTime.class, "datetime")
				.user("datetimes?")
				.name("Date Time")
				.defaultExpression(new EventValueExpression<>(DateTime.class))
				.serializeAs(DateTime.class));
		Classes.registerClass(new ClassInfo<>(TimeZone.class, "timezones")
				.user("timezones?")
				.name("Time Zone")
				.defaultExpression(new EventValueExpression<>(TimeZone.class))
				.serializeAs(TimeZone.class));
	}

}
