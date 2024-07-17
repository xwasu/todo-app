package io.github.xwasu.logic;

import io.github.xwasu.model.TaskGroup;
import io.github.xwasu.model.TaskGroupRepository;
import io.github.xwasu.model.projection.GroupReadModel;
import io.github.xwasu.model.projection.GroupWriteModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {
    private TaskGroupRepository repository;

    TaskGroupService(final TaskGroupRepository repository) {
        this.repository = repository;
    }

    public GroupReadModel createGroup(GroupWriteModel source) {
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }
}
