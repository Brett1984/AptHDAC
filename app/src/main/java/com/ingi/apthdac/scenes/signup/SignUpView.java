package com.ingi.apthdac.scenes.signup;

import com.ingi.apthdac.common.View;
import com.ingi.apthdac.common.models.SignUpForm;

public interface SignUpView extends View {
    void onClickSignup(android.view.View view);
    void bindSignupForm(SignUpForm signUpForm);
}
