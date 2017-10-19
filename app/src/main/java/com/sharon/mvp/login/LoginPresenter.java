package com.sharon.mvp.login;

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
