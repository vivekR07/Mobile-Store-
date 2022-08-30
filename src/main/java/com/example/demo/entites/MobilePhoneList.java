package com.example.demo.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MobilePhoneList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long listId;
	
    @OneToMany
    @JoinColumn(name="listId")
    private List<MobilePhone> mobilePhones=new ArrayList<MobilePhone>();
    
}
