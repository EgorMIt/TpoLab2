public class Functions {
    public static double sin(double x, double eps) {
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }
        double fact = 1, result_l = 1, result = 0, xx, pow;
        int sign = 1, cnt = 1;

        if (x >= 0) {
            while (x > Math.PI * 2) {
                x -= Math.PI * 2;
            }
        } else if (x < 0) {
            while (x < Math.PI * 2) {
                x += Math.PI * 2;
            }
        }
        xx = x * x;
        pow = x;

        while (Math.abs(result_l - result) > eps) {
            fact /= cnt;
            result_l = result;
            result += sign * pow * fact;
            sign = -sign;
            fact /= (cnt + 1);
            pow *= xx;
            cnt += 2;
        }
        return result;
    }


    public static double cos(double x, double eps) {
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }
        double s_x = x;
        while (360 < x) {
            x /= 4;
        }
        if (x < -Math.PI) {
            while (x < -Math.PI) x += 2 * Math.PI;
        }
        if (x > Math.PI) {
            while (x > Math.PI) x -= 2 * Math.PI;
        }

        if (x > Math.PI / 2 || x < -Math.PI / 2) {
            return -1 * Math.sqrt(1 - sin(s_x, eps) * sin(s_x, eps));
        }
        return Math.sqrt(1 - sin(s_x, eps) * sin(s_x, eps));
    }

    public static double sec(double x, double eps) {
        return 1 / cos(x, eps);
    }

    public static double ln(double x, double eps) {
        if (Double.isNaN(x) || x < (double) 0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double currentValue = (x - 1) / (x + 1);
        int step = 1;
        while (Math.abs(currentValue) > eps / 2) {
            sum += currentValue;
            currentValue = (2 * step - 1) * currentValue * constant / (2 * step + 1);
            step++;
        }
        sum *= 2;
        return sum;
    }

    public static double log(double a, double b, double esp) {
        return ln(b, esp) / ln(a, esp);
    }

    public static double SystemSolve(double x, double eps) {
        if (x <= 0) return sec(x, eps);
        else
            return ((log(2, x, eps) * log(2, x, eps) + log(10, x, eps) * log(2, x, eps)) / log(2, x, eps)) / ln(x, eps);
    }
}
