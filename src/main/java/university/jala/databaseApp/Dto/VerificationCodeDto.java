package university.jala.databaseApp.Dto;

public class VerificationCodeDto {

    private String verificationCode;

    public VerificationCodeDto() {}

    public VerificationCodeDto(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

}
