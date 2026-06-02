package Day_20;



public class MoodAnalysisException extends Exception {

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
