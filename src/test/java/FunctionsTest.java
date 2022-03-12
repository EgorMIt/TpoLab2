import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FunctionsTest {

    double functionEps = 0.01;
    double eps = 0.1;

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 2, Math.PI, Math.PI * 2, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void sin(double value) {
        Assertions.assertEquals(Math.sin(value), Functions.sin(value, functionEps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 2, Math.PI, Math.PI * 2, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void cos(double value) {
        Assertions.assertEquals(Math.cos(value), Functions.cos(value, functionEps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 2, Math.PI, Math.PI * 2, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void sec(double value) {
        Assertions.assertEquals(1 / Math.cos(value), Functions.sec(value, functionEps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 1, 2, Math.E, 10, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void ln(double value) {
        Assertions.assertEquals(Math.log(value), Functions.ln(value, functionEps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 1, 2, Math.E, 10, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void log(double value) {
        Assertions.assertEquals(Math.log10(value), Functions.log(10, value, functionEps), eps);
    }
}