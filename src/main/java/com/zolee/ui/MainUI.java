package com.zolee.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.zolee.domain.DefaultUser;
import com.zolee.service.CheckDefaultUserData;

@SpringUI
@Theme("valo")
public class MainUI extends UI {

	private CheckDefaultUserData checkDefaultUserData;

	@Autowired
	public void setCheckDefaultUserData(CheckDefaultUserData checkDefaultUserData) {
		this.checkDefaultUserData = checkDefaultUserData;
	}

	private VerticalLayout mainLayout;
	private HorizontalLayout titleLayout;
	private HorizontalLayout inputLayout;
	private HorizontalLayout resultLayout;
	private Label titleLabel;
	private TextField nameField;
	private PasswordField passwordField;
	private Button okButton;
	private Label resultLabel;

	@Override
	protected void init(VaadinRequest request) {
		
		mainLayout = new VerticalLayout();
		titleLayout = new HorizontalLayout();
		inputLayout = new HorizontalLayout();
		resultLayout = new HorizontalLayout();
		titleLabel = new Label("Írd be a nevet és jelszót: ");
		nameField = new TextField("Név: ");
		passwordField = new PasswordField("Jelszó: ");
		okButton = new Button("OK");
		resultLabel = new Label("Még nincs eredmény...");
		
		mainLayout.addComponents(titleLayout, inputLayout, resultLayout);
		titleLayout.addComponent(titleLabel);
		inputLayout.addComponents(nameField, passwordField);
		resultLayout.addComponents(okButton, resultLabel);
		
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		setContent(mainLayout);
		
		okButton.addClickListener(e -> upDate());
	}

	private void upDate() {
		if(checkDefaultUserData.checkUser(new DefaultUser(nameField.getValue(), passwordField.getValue()))) {
			resultLabel.setValue("A név/jelszó megfelelő!");
		}else {
			resultLabel.setValue("A név/jelszó nem megfelelő!");
		}
	}

}
