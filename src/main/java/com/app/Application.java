package com.app;

import com.app.entity.Note;
import com.app.service.NoteService;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.app")
public class Application {
	@Autowired
	private NoteService notes;

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure()
				.baselineOnMigrate(true)
				.dataSource("jdbc:h2:file:./notedatabase", "name", "pa$$")
				.table("flyway_schema_history")
				.locations("/db/migration")
				.load();
		flyway.migrate();

		SpringApplication.run(Application.class, args);
	}
}