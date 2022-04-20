package io.github.mat3e.controller;

import io.github.mat3e.TaskConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/info")
class InfoController {
    private DataSourceProperties datasource;
    private TaskConfigurationProperties myProp;

    InfoController(final DataSourceProperties datasource, final TaskConfigurationProperties myProp) {
        this.datasource = datasource;
        this.myProp = myProp;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/url")
    String url() {
        return datasource.getUrl();
    }

    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/prop")
    boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }
}
