package src.domain.controllers;

import src.presentation.CtrlPresenter;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CtrlPresenter ctrlPresenter = new CtrlPresenter();
            }
        });
    }
}