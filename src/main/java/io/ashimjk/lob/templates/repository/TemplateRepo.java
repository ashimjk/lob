package io.ashimjk.lob.templates.repository;

import io.ashimjk.lob.templates.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepo extends JpaRepository<Template, Long> {
}
