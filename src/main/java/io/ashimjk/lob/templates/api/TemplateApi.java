package io.ashimjk.lob.templates.api;

import io.ashimjk.lob.templates.entity.Template;
import io.ashimjk.lob.templates.repository.TemplateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/templates")
public class TemplateApi {

    private final TemplateRepo templateRepo;

    @GetMapping
    public ResponseEntity<List<Template>> getTemplates() {
        return ResponseEntity.ok(this.templateRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplate(@PathVariable long id) {
        return ResponseEntity.of(this.templateRepo.findById(id));
    }

    @PostMapping
    public ResponseEntity<Template> saveTemplate(@RequestBody Template template) {
        return new ResponseEntity<>(this.templateRepo.save(template), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Template> updateTemplate(@PathVariable long id, @RequestBody Template template) {
        Optional<Template> updatedTemplate = this.templateRepo.findById(id);
        updatedTemplate
                .map(t -> t.merge(template))
                .map(templateRepo::save)
                .orElseThrow(() -> new RuntimeException("template id not found"));

        return ResponseEntity.of(updatedTemplate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable long id) {
        this.templateRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
