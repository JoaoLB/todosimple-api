package com.joaoferreira.springboot.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = task.TABLE_NAME)
public class task {
    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private user user;

    @Column(name = "descripition", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;


    public task() {
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public user getUser() {
        return this.user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

        @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof task))
            return false;
        task other = (task) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            /**else if (!this.id.equals other.id)
                return false;**/
        return Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user)
            && Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }
    
}
