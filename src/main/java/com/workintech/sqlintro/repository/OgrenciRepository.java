package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    String QUESTION_1 =
            "SELECT * FROM ogrenci ORDER BY ogrno ASC";

    String QUESTION_2 =
            "SELECT * FROM ogrenci WHERE cinsiyet = 'K' ORDER BY ogrno ASC";

    String QUESTION_3 =
            "SELECT DISTINCT sinif FROM ogrenci";

    String QUESTION_4 =
            "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'";

    String QUESTION_5 =
            "SELECT * FROM ogrenci WHERE ogrno BETWEEN 5 AND 10 AND cinsiyet = 'K' ORDER BY ograd ASC";

    String QUESTION_6 =
            "SELECT * FROM ogrenci ORDER BY ograd ASC";

    String QUESTION_7 =
            "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC";

    String QUESTION_8 =
            "SELECT * FROM ogrenci WHERE dtarih IS NOT NULL ORDER BY dtarih DESC LIMIT 1";

    String QUESTION_9 =
            "SELECT * FROM ogrenci WHERE dtarih IS NOT NULL ORDER BY dtarih ASC LIMIT 1";

    String QUESTION_10 =
            "SELECT * FROM ogrenci WHERE LOWER(ograd) LIKE '_e%'";


    @Override
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();


    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();


    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();


    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();


    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();


    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();


    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();


    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();


    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();


    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}
