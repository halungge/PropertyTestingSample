package mlz.money;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.math.BigDecimal;


public class PositiveNumberGenerator extends Generator<BigDecimal> {
    protected PositiveNumberGenerator(Class<BigDecimal> type) {
        super(type);
    }

    @Override
    public BigDecimal generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        double value = sourceOfRandomness.nextDouble();
        return BigDecimal.ZERO;

    }
}
