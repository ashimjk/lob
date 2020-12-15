package io.ashimjk.lob.templates.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "seq", initialValue = 100, allocationSize = 5)
    // @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    // @TableGenerator(name = "tab", initialValue = 1, allocationSize = 100,
    //         table = "tabseq",
    //         pkColumnName = "tab_pk_col_name",
    //         valueColumnName = "tab_val_name")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "template")
    private String template;

}
