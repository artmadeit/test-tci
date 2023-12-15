package pe.net.tci.test.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@SQLDelete(sql = "UPDATE empresa SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Digits(integer = 11, fraction = 0)
    @Setter
    String ruc;
    @NotBlank
    @Setter
    String razonSocial;
    @NotBlank
    @Setter
    String direccion;

    boolean isDeleted = false;

    @CreatedDate
    LocalDateTime createDate;
}
