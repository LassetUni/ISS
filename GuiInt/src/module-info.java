module GuiInt {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxm, javafx.base,javafx.fxml;
	exports application;
}
