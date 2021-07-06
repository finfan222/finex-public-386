package net.sf.l2j.tools.instruments;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.stream.Stream;

/**
 *
 * @project acis_public
 * @author finfan: 06.07.2021
 */
@Slf4j
public class Reflect {

	public static final Reflections REFLECTIONS = new Reflections(new ConfigurationBuilder()
		.addScanners(new MethodAnnotationsScanner(), new FieldAnnotationsScanner(), new TypeAnnotationsScanner())
		.setUrls(ClasspathHelper.forJavaClassPath()));

	public static void clean(Object source) {
		Long nano = System.nanoTime();
		Stream.of(source.getClass().getDeclaredFields()).forEach(f -> {
			f.setAccessible(true);
			try {
				Object o = f.get(source);
				if(o instanceof Number) {
					f.set(source, 0);
				} else {
					f.set(source, null);
				}
			} catch (IllegalAccessException e) {
				log.error("Can't clean all declared fields in {}.", source, e);
			}
		});
		nano = System.nanoTime() - nano;
		log.info("Reflection clear {} for: {} ms.", source, (nano / 1000000.f));
	}
}
