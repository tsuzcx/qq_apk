package org.junit.runners.parameterized;

import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

public class BlockJUnit4ClassRunnerWithParametersFactory
  implements ParametersRunnerFactory
{
  public Runner createRunnerForTestWithParameters(TestWithParameters paramTestWithParameters)
    throws InitializationError
  {
    return new BlockJUnit4ClassRunnerWithParameters(paramTestWithParameters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory
 * JD-Core Version:    0.7.0.1
 */