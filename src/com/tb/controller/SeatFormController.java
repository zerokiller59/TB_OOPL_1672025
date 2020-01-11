//package com.tb.controller;
//
//import com.tb.entity.Seat;
//import com.tb.entity.User;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Group;
//import javafx.scene.Node;
//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
//import javafx.scene.control.Label;
//
///**
// * FXML Controller class
// *
// * @author Velz
// */
//public class SeatFormController implements Initializable {
//
//    @FXML
//    private Label lblMovie;
//    @FXML
//    private Label lblStudio;
//    @FXML
//    private Label lblStartAt;
//    @FXML
//    private CheckBox L20;
//    @FXML
//    private CheckBox L19;
//    @FXML
//    private CheckBox L18;
//    @FXML
//    private CheckBox L17;
//    @FXML
//    private CheckBox L16;
//    @FXML
//    private CheckBox L15;
//    @FXML
//    private CheckBox L14;
//    @FXML
//    private CheckBox L13;
//    @FXML
//    private CheckBox L12;
//    @FXML
//    private CheckBox L11;
//    @FXML
//    private CheckBox L10;
//    @FXML
//    private CheckBox L9;
//    @FXML
//    private CheckBox L8;
//    @FXML
//    private CheckBox L7;
//    @FXML
//    private CheckBox L6;
//    @FXML
//    private CheckBox L5;
//    @FXML
//    private CheckBox L4;
//    @FXML
//    private CheckBox L3;
//    @FXML
//    private CheckBox L2;
//    @FXML
//    private CheckBox L1;
//    @FXML
//    private CheckBox K20;
//    @FXML
//    private CheckBox K19;
//    @FXML
//    private CheckBox K18;
//    @FXML
//    private CheckBox K17;
//    @FXML
//    private CheckBox K16;
//    @FXML
//    private CheckBox K15;
//    @FXML
//    private CheckBox K14;
//    @FXML
//    private CheckBox K13;
//    @FXML
//    private CheckBox K12;
//    @FXML
//    private CheckBox K11;
//    @FXML
//    private CheckBox K10;
//    @FXML
//    private CheckBox K9;
//    @FXML
//    private CheckBox K8;
//    @FXML
//    private CheckBox K7;
//    @FXML
//    private CheckBox K6;
//    @FXML
//    private CheckBox K5;
//    @FXML
//    private CheckBox K4;
//    @FXML
//    private CheckBox K3;
//    @FXML
//    private CheckBox K2;
//    @FXML
//    private CheckBox K1;
//    @FXML
//    private CheckBox J20;
//    @FXML
//    private CheckBox J19;
//    @FXML
//    private CheckBox J18;
//    @FXML
//    private CheckBox J17;
//    @FXML
//    private CheckBox J16;
//    @FXML
//    private CheckBox J15;
//    @FXML
//    private CheckBox J14;
//    @FXML
//    private CheckBox J13;
//    @FXML
//    private CheckBox J12;
//    @FXML
//    private CheckBox J11;
//    @FXML
//    private CheckBox J10;
//    @FXML
//    private CheckBox J9;
//    @FXML
//    private CheckBox J8;
//    @FXML
//    private CheckBox J7;
//    @FXML
//    private CheckBox J6;
//    @FXML
//    private CheckBox J5;
//    @FXML
//    private CheckBox J4;
//    @FXML
//    private CheckBox J3;
//    @FXML
//    private CheckBox J2;
//    @FXML
//    private CheckBox J1;
//    @FXML
//    private CheckBox I20;
//    @FXML
//    private CheckBox I19;
//    @FXML
//    private CheckBox I18;
//    @FXML
//    private CheckBox I17;
//    @FXML
//    private CheckBox I16;
//    @FXML
//    private CheckBox I15;
//    @FXML
//    private CheckBox I14;
//    @FXML
//    private CheckBox I13;
//    @FXML
//    private CheckBox I12;
//    @FXML
//    private CheckBox I11;
//    @FXML
//    private CheckBox I10;
//    @FXML
//    private CheckBox I9;
//    @FXML
//    private CheckBox I8;
//    @FXML
//    private CheckBox I7;
//    @FXML
//    private CheckBox I6;
//    @FXML
//    private CheckBox I5;
//    @FXML
//    private CheckBox I4;
//    @FXML
//    private CheckBox I3;
//    @FXML
//    private CheckBox I2;
//    @FXML
//    private CheckBox I1;
//    @FXML
//    private CheckBox H20;
//    @FXML
//    private CheckBox H19;
//    @FXML
//    private CheckBox H18;
//    @FXML
//    private CheckBox H17;
//    @FXML
//    private CheckBox H16;
//    @FXML
//    private CheckBox H15;
//    @FXML
//    private CheckBox H14;
//    @FXML
//    private CheckBox H13;
//    @FXML
//    private CheckBox H12;
//    @FXML
//    private CheckBox H11;
//    @FXML
//    private CheckBox H10;
//    @FXML
//    private CheckBox H9;
//    @FXML
//    private CheckBox H8;
//    @FXML
//    private CheckBox H7;
//    @FXML
//    private CheckBox H6;
//    @FXML
//    private CheckBox H5;
//    @FXML
//    private CheckBox H4;
//    @FXML
//    private CheckBox H3;
//    @FXML
//    private CheckBox H2;
//    @FXML
//    private CheckBox H1;
//    @FXML
//    private CheckBox G20;
//    @FXML
//    private CheckBox G19;
//    @FXML
//    private CheckBox G18;
//    @FXML
//    private CheckBox G17;
//    @FXML
//    private CheckBox G16;
//    @FXML
//    private CheckBox G15;
//    @FXML
//    private CheckBox G14;
//    @FXML
//    private CheckBox G13;
//    @FXML
//    private CheckBox G12;
//    @FXML
//    private CheckBox G11;
//    @FXML
//    private CheckBox G10;
//    @FXML
//    private CheckBox G9;
//    @FXML
//    private CheckBox G8;
//    @FXML
//    private CheckBox G7;
//    @FXML
//    private CheckBox G6;
//    @FXML
//    private CheckBox G5;
//    @FXML
//    private CheckBox G4;
//    @FXML
//    private CheckBox G3;
//    @FXML
//    private CheckBox G2;
//    @FXML
//    private CheckBox G1;
//    @FXML
//    private CheckBox F20;
//    @FXML
//    private CheckBox F19;
//    @FXML
//    private CheckBox F18;
//    @FXML
//    private CheckBox F17;
//    @FXML
//    private CheckBox F16;
//    @FXML
//    private CheckBox F15;
//    @FXML
//    private CheckBox F14;
//    @FXML
//    private CheckBox F13;
//    @FXML
//    private CheckBox F12;
//    @FXML
//    private CheckBox F11;
//    @FXML
//    private CheckBox F10;
//    @FXML
//    private CheckBox F9;
//    @FXML
//    private CheckBox F8;
//    @FXML
//    private CheckBox F7;
//    @FXML
//    private CheckBox F6;
//    @FXML
//    private CheckBox F5;
//    @FXML
//    private CheckBox F4;
//    @FXML
//    private CheckBox F3;
//    @FXML
//    private CheckBox F2;
//    @FXML
//    private CheckBox F1;
//    @FXML
//    private CheckBox E20;
//    @FXML
//    private CheckBox E19;
//    @FXML
//    private CheckBox E18;
//    @FXML
//    private CheckBox E17;
//    @FXML
//    private CheckBox E16;
//    @FXML
//    private CheckBox E15;
//    @FXML
//    private CheckBox E14;
//    @FXML
//    private CheckBox E13;
//    @FXML
//    private CheckBox E12;
//    @FXML
//    private CheckBox E11;
//    @FXML
//    private CheckBox E10;
//    @FXML
//    private CheckBox E9;
//    @FXML
//    private CheckBox E8;
//    @FXML
//    private CheckBox E7;
//    @FXML
//    private CheckBox E6;
//    @FXML
//    private CheckBox E5;
//    @FXML
//    private CheckBox E4;
//    @FXML
//    private CheckBox E3;
//    @FXML
//    private CheckBox E2;
//    @FXML
//    private CheckBox E1;
//    @FXML
//    private CheckBox D20;
//    @FXML
//    private CheckBox D19;
//    @FXML
//    private CheckBox D18;
//    @FXML
//    private CheckBox D17;
//    @FXML
//    private CheckBox D16;
//    @FXML
//    private CheckBox D15;
//    @FXML
//    private CheckBox D14;
//    @FXML
//    private CheckBox D13;
//    @FXML
//    private CheckBox D12;
//    @FXML
//    private CheckBox D11;
//    @FXML
//    private CheckBox D10;
//    @FXML
//    private CheckBox D9;
//    @FXML
//    private CheckBox D8;
//    @FXML
//    private CheckBox D7;
//    @FXML
//    private CheckBox D6;
//    @FXML
//    private CheckBox D5;
//    @FXML
//    private CheckBox D4;
//    @FXML
//    private CheckBox D3;
//    @FXML
//    private CheckBox D2;
//    @FXML
//    private CheckBox D1;
//    @FXML
//    private CheckBox C20;
//    @FXML
//    private CheckBox C19;
//    @FXML
//    private CheckBox C18;
//    @FXML
//    private CheckBox C17;
//    @FXML
//    private CheckBox C16;
//    @FXML
//    private CheckBox C15;
//    @FXML
//    private CheckBox C14;
//    @FXML
//    private CheckBox C13;
//    @FXML
//    private CheckBox C12;
//    @FXML
//    private CheckBox C11;
//    @FXML
//    private CheckBox C10;
//    @FXML
//    private CheckBox C9;
//    @FXML
//    private CheckBox C8;
//    @FXML
//    private CheckBox C7;
//    @FXML
//    private CheckBox C6;
//    @FXML
//    private CheckBox C5;
//    @FXML
//    private CheckBox C4;
//    @FXML
//    private CheckBox C3;
//    @FXML
//    private CheckBox C2;
//    @FXML
//    private CheckBox C1;
//    @FXML
//    private CheckBox B20;
//    @FXML
//    private CheckBox B19;
//    @FXML
//    private CheckBox B18;
//    @FXML
//    private CheckBox B17;
//    @FXML
//    private CheckBox B16;
//    @FXML
//    private CheckBox B15;
//    @FXML
//    private CheckBox B14;
//    @FXML
//    private CheckBox B13;
//    @FXML
//    private CheckBox B12;
//    @FXML
//    private CheckBox B11;
//    @FXML
//    private CheckBox B10;
//    @FXML
//    private CheckBox B9;
//    @FXML
//    private CheckBox B8;
//    @FXML
//    private CheckBox B7;
//    @FXML
//    private CheckBox B6;
//    @FXML
//    private CheckBox B5;
//    @FXML
//    private CheckBox B4;
//    @FXML
//    private CheckBox B3;
//    @FXML
//    private CheckBox B2;
//    @FXML
//    private CheckBox B1;
//    @FXML
//    private CheckBox A20;
//    @FXML
//    private CheckBox A19;
//    @FXML
//    private CheckBox A18;
//    @FXML
//    private CheckBox A17;
//    @FXML
//    private CheckBox A16;
//    @FXML
//    private CheckBox A15;
//    @FXML
//    private CheckBox A14;
//    @FXML
//    private CheckBox A13;
//    @FXML
//    private CheckBox A12;
//    @FXML
//    private CheckBox A11;
//    @FXML
//    private CheckBox A10;
//    @FXML
//    private CheckBox A9;
//    @FXML
//    private CheckBox A8;
//    @FXML
//    private CheckBox A7;
//    @FXML
//    private CheckBox A6;
//    @FXML
//    private CheckBox A5;
//    @FXML
//    private CheckBox A4;
//    @FXML
//    private CheckBox A3;
//    @FXML
//    private CheckBox A2;
//    @FXML
//    private CheckBox A1;
//    @FXML
//    private Label lblPrice;
//    @FXML
//    private Label lblSeat;
//    @FXML
//    private Label lblBalance;
//    @FXML
//    private Label lblCost;
//    @FXML
//    private Button btnConfirm;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }
//
//    @FXML
//    private void btnConfirmAction(ActionEvent event) {
//    }
//
////    private ObservableList<Seat> allSelectedCheckboxes() {
////        Group group = new Group();
////        group.getChildren().add(L20);
////        group.getChildren().add(L19);
////        group.getChildren().add(L18);
////        group.getChildren().add(L17);
////        group.getChildren().add(L16);
////        group.getChildren().add(L15);
////        group.getChildren().add(L14);
////        group.getChildren().add(L13);
////        group.getChildren().add(L12);
////        group.getChildren().add(L11);
////        group.getChildren().add(L10);
////        group.getChildren().add(L9);
////        group.getChildren().add(L8);
////        group.getChildren().add(L7);
////        group.getChildren().add(L6);
////        group.getChildren().add(L5);
////        group.getChildren().add(L4);
////        group.getChildren().add(L3);
////        group.getChildren().add(L2);
////        group.getChildren().add(L1);
////        group.getChildren().add(K20);
////        group.getChildren().add(K19);
////        group.getChildren().add(K18);
////        group.getChildren().add(K17);
////        group.getChildren().add(K16);
////        group.getChildren().add(K15);
////        group.getChildren().add(K14);
////        group.getChildren().add(K13);
////        group.getChildren().add(K12);
////        group.getChildren().add(K11);
////        group.getChildren().add(K10);
////        group.getChildren().add(K9);
////        group.getChildren().add(K8);
////        group.getChildren().add(K7);
////        group.getChildren().add(K6);
////        group.getChildren().add(K5);
////        group.getChildren().add(K4);
////        group.getChildren().add(K3);
////        group.getChildren().add(K2);
////        group.getChildren().add(K1);
////        group.getChildren().add(J20);
////        group.getChildren().add(J19);
////        group.getChildren().add(J18);
////        group.getChildren().add(J17);
////        group.getChildren().add(J16);
////        group.getChildren().add(J15);
////        group.getChildren().add(J14);
////        group.getChildren().add(J13);
////        group.getChildren().add(J12);
////        group.getChildren().add(J11);
////        group.getChildren().add(J10);
////        group.getChildren().add(J9);
////        group.getChildren().add(J8);
////        group.getChildren().add(J7);
////        group.getChildren().add(J6);
////        group.getChildren().add(J5);
////        group.getChildren().add(J4);
////        group.getChildren().add(J3);
////        group.getChildren().add(J2);
////        group.getChildren().add(J1);
////        group.getChildren().add(I20);
////        group.getChildren().add(I19);
////        group.getChildren().add(I18);
////        group.getChildren().add(I17);
////        group.getChildren().add(I16);
////        group.getChildren().add(I15);
////        group.getChildren().add(I14);
////        group.getChildren().add(I13);
////        group.getChildren().add(I12);
////        group.getChildren().add(I11);
////        group.getChildren().add(I10);
////        group.getChildren().add(I9);
////        group.getChildren().add(I8);
////        group.getChildren().add(I7);
////        group.getChildren().add(I6);
////        group.getChildren().add(I5);
////        group.getChildren().add(I4);
////        group.getChildren().add(I3);
////        group.getChildren().add(I2);
////        group.getChildren().add(I1);
////        group.getChildren().add(H20);
////        group.getChildren().add(H19);
////        group.getChildren().add(H18);
////        group.getChildren().add(H17);
////        group.getChildren().add(H16);
////        group.getChildren().add(H15);
////        group.getChildren().add(H14);
////        group.getChildren().add(H13);
////        group.getChildren().add(H12);
////        group.getChildren().add(H11);
////        group.getChildren().add(H10);
////        group.getChildren().add(H9);
////        group.getChildren().add(H8);
////        group.getChildren().add(H7);
////        group.getChildren().add(H6);
////        group.getChildren().add(H5);
////        group.getChildren().add(H4);
////        group.getChildren().add(H3);
////        group.getChildren().add(H2);
////        group.getChildren().add(H1);
////        group.getChildren().add(G20);
////        group.getChildren().add(G19);
////        group.getChildren().add(G18);
////        group.getChildren().add(G17);
////        group.getChildren().add(G16);
////        group.getChildren().add(G15);
////        group.getChildren().add(G14);
////        group.getChildren().add(G13);
////        group.getChildren().add(G12);
////        group.getChildren().add(G11);
////        group.getChildren().add(G10);
////        group.getChildren().add(G9);
////        group.getChildren().add(G8);
////        group.getChildren().add(G7);
////        group.getChildren().add(G6);
////        group.getChildren().add(G5);
////        group.getChildren().add(G4);
////        group.getChildren().add(G3);
////        group.getChildren().add(G2);
////        group.getChildren().add(G1);
////        group.getChildren().add(F20);
////        group.getChildren().add(F19);
////        group.getChildren().add(F18);
////        group.getChildren().add(F17);
////        group.getChildren().add(F16);
////        group.getChildren().add(F15);
////        group.getChildren().add(F14);
////        group.getChildren().add(F13);
////        group.getChildren().add(F12);
////        group.getChildren().add(F11);
////        group.getChildren().add(F10);
////        group.getChildren().add(F9);
////        group.getChildren().add(F8);
////        group.getChildren().add(F7);
////        group.getChildren().add(F6);
////        group.getChildren().add(F5);
////        group.getChildren().add(F4);
////        group.getChildren().add(F3);
////        group.getChildren().add(F2);
////        group.getChildren().add(F1);
////        group.getChildren().add(E20);
////        group.getChildren().add(E19);
////        group.getChildren().add(E18);
////        group.getChildren().add(E17);
////        group.getChildren().add(E16);
////        group.getChildren().add(E15);
////        group.getChildren().add(E14);
////        group.getChildren().add(E13);
////        group.getChildren().add(E12);
////        group.getChildren().add(E11);
////        group.getChildren().add(E10);
////        group.getChildren().add(E9);
////        group.getChildren().add(E8);
////        group.getChildren().add(E7);
////        group.getChildren().add(E6);
////        group.getChildren().add(E5);
////        group.getChildren().add(E4);
////        group.getChildren().add(E3);
////        group.getChildren().add(E2);
////        group.getChildren().add(E1);
////        group.getChildren().add(D20);
////        group.getChildren().add(D19);
////        group.getChildren().add(D18);
////        group.getChildren().add(D17);
////        group.getChildren().add(D16);
////        group.getChildren().add(D15);
////        group.getChildren().add(D14);
////        group.getChildren().add(D13);
////        group.getChildren().add(D12);
////        group.getChildren().add(D11);
////        group.getChildren().add(D10);
////        group.getChildren().add(D9);
////        group.getChildren().add(D8);
////        group.getChildren().add(D7);
////        group.getChildren().add(D6);
////        group.getChildren().add(D5);
////        group.getChildren().add(D4);
////        group.getChildren().add(D3);
////        group.getChildren().add(D2);
////        group.getChildren().add(D1);
////        group.getChildren().add(C20);
////        group.getChildren().add(C19);
////        group.getChildren().add(C18);
////        group.getChildren().add(C17);
////        group.getChildren().add(C16);
////        group.getChildren().add(C15);
////        group.getChildren().add(C14);
////        group.getChildren().add(C13);
////        group.getChildren().add(C12);
////        group.getChildren().add(C11);
////        group.getChildren().add(C10);
////        group.getChildren().add(C9);
////        group.getChildren().add(C8);
////        group.getChildren().add(C7);
////        group.getChildren().add(C6);
////        group.getChildren().add(C5);
////        group.getChildren().add(C4);
////        group.getChildren().add(C3);
////        group.getChildren().add(C2);
////        group.getChildren().add(C1);
////        group.getChildren().add(B20);
////        group.getChildren().add(B19);
////        group.getChildren().add(B18);
////        group.getChildren().add(B17);
////        group.getChildren().add(B16);
////        group.getChildren().add(B15);
////        group.getChildren().add(B14);
////        group.getChildren().add(B13);
////        group.getChildren().add(B12);
////        group.getChildren().add(B11);
////        group.getChildren().add(B10);
////        group.getChildren().add(B9);
////        group.getChildren().add(B8);
////        group.getChildren().add(B7);
////        group.getChildren().add(B6);
////        group.getChildren().add(B5);
////        group.getChildren().add(B4);
////        group.getChildren().add(B3);
////        group.getChildren().add(B2);
////        group.getChildren().add(B1);
////        group.getChildren().add(A20);
////        group.getChildren().add(A19);
////        group.getChildren().add(A18);
////        group.getChildren().add(A17);
////        group.getChildren().add(A16);
////        group.getChildren().add(A15);
////        group.getChildren().add(A14);
////        group.getChildren().add(A13);
////        group.getChildren().add(A12);
////        group.getChildren().add(A11);
////        group.getChildren().add(A10);
////        group.getChildren().add(A9);
////        group.getChildren().add(A8);
////        group.getChildren().add(A7);
////        group.getChildren().add(A6);
////        group.getChildren().add(A5);
////        group.getChildren().add(A4);
////        group.getChildren().add(A3);
////        group.getChildren().add(A2);
////        group.getChildren().add(A1);
////        for (Node i : group.getChildren()) {
////            CheckBox cb = (CheckBox) i;
////            if (cb.isSelected()) {
////                Seat s = new Seat();
////                s.setRow(cb.getId().charAt(0));
////                s.setNumber(Integer.valueOf(cb.getId().substring(1)));
////            }
////        }
////    }
//}
