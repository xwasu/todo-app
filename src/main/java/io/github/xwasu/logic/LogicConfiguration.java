package io.github.xwasu.logic;

import io.github.xwasu.TaskConfigurationProperties;
import io.github.xwasu.model.ProjectRepository;
import io.github.xwasu.model.TaskGroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext.xml")
class LogicConfiguration {
    /*@Bean
    ProjectService service(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskConfigurationProperties config
    ) {
        return new ProjectService(repository, taskGroupRepository, config);
    }*/
}
