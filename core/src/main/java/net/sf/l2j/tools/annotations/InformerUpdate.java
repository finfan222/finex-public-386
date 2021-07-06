package net.sf.l2j.tools.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

/**
 *
 * @project acis_public
 * @author finfan: 05.07.2021
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InformerUpdate {
	String description() default "";
	Class<?> date() default LocalDate.class;
}
