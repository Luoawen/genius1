package com.career.genius.port.dao.template;

import com.career.genius.domain.template.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateDao extends JpaRepository<Template,String> {

    Template findTemplateById(String templateId);
}
