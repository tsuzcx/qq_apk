package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic
{
  private static final int AMDF_FREQUENCY = 4000;
  private static final int MAXIMUM_PITCH = 400;
  private static final int MINIMUM_PITCH = 65;
  private final short[] downSampleBuffer;
  private short[] inputBuffer;
  private int inputBufferSize;
  private final int inputSampleRateHz;
  private int maxDiff;
  private final int maxPeriod;
  private final int maxRequired;
  private int minDiff;
  private final int minPeriod;
  private int newRatePosition;
  private final int numChannels;
  private int numInputSamples;
  private int numOutputSamples;
  private int numPitchSamples;
  private int oldRatePosition;
  private short[] outputBuffer;
  private int outputBufferSize;
  private final float pitch;
  private short[] pitchBuffer;
  private int pitchBufferSize;
  private int prevMinDiff;
  private int prevPeriod;
  private final float rate;
  private int remainingInputToCopy;
  private final float speed;
  
  public Sonic(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    this.inputSampleRateHz = paramInt1;
    this.numChannels = paramInt2;
    this.minPeriod = (paramInt1 / 400);
    this.maxPeriod = (paramInt1 / 65);
    this.maxRequired = (this.maxPeriod * 2);
    this.downSampleBuffer = new short[this.maxRequired];
    this.inputBufferSize = this.maxRequired;
    this.inputBuffer = new short[this.maxRequired * paramInt2];
    this.outputBufferSize = this.maxRequired;
    this.outputBuffer = new short[this.maxRequired * paramInt2];
    this.pitchBufferSize = this.maxRequired;
    this.pitchBuffer = new short[this.maxRequired * paramInt2];
    this.oldRatePosition = 0;
    this.newRatePosition = 0;
    this.prevPeriod = 0;
    this.speed = paramFloat1;
    this.pitch = paramFloat2;
    this.rate = (paramInt1 / paramInt3);
  }
  
  private void adjustRate(float paramFloat, int paramInt)
  {
    if (this.numOutputSamples == paramInt) {
      return;
    }
    int j = (int)(this.inputSampleRateHz / paramFloat);
    int i = this.inputSampleRateHz;
    while ((j > 16384) || (i > 16384))
    {
      j /= 2;
      i /= 2;
    }
    moveNewSamplesToPitchBuffer(paramInt);
    paramInt = 0;
    if (paramInt < this.numPitchSamples - 1)
    {
      while ((this.oldRatePosition + 1) * j > this.newRatePosition * i)
      {
        enlargeOutputBufferIfNeeded(1);
        int k = 0;
        while (k < this.numChannels)
        {
          this.outputBuffer[(this.numOutputSamples * this.numChannels + k)] = interpolate(this.pitchBuffer, this.numChannels * paramInt + k, i, j);
          k += 1;
        }
        this.newRatePosition += 1;
        this.numOutputSamples += 1;
      }
      this.oldRatePosition += 1;
      if (this.oldRatePosition == i)
      {
        this.oldRatePosition = 0;
        if (this.newRatePosition != j) {
          break label225;
        }
      }
      label225:
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        this.newRatePosition = 0;
        paramInt += 1;
        break;
      }
    }
    removePitchSamples(this.numPitchSamples - 1);
  }
  
  private void changeSpeed(float paramFloat)
  {
    if (this.numInputSamples < this.maxRequired) {
      return;
    }
    int k = this.numInputSamples;
    int j = 0;
    int i;
    if (this.remainingInputToCopy > 0) {
      i = j + copyInputToOutput(j);
    }
    for (;;)
    {
      j = i;
      if (this.maxRequired + i <= k) {
        break;
      }
      removeProcessedInputSamples(i);
      return;
      i = findPitchPeriod(this.inputBuffer, j, true);
      if (paramFloat > 1.0D) {
        i = j + (i + skipPitchPeriod(this.inputBuffer, j, paramFloat, i));
      } else {
        i = j + insertPitchPeriod(this.inputBuffer, j, paramFloat, i);
      }
    }
  }
  
  private int copyInputToOutput(int paramInt)
  {
    int i = Math.min(this.maxRequired, this.remainingInputToCopy);
    copyToOutput(this.inputBuffer, paramInt, i);
    this.remainingInputToCopy -= i;
    return i;
  }
  
  private void copyToOutput(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    enlargeOutputBufferIfNeeded(paramInt2);
    System.arraycopy(paramArrayOfShort, this.numChannels * paramInt1, this.outputBuffer, this.numOutputSamples * this.numChannels, this.numChannels * paramInt2);
    this.numOutputSamples += paramInt2;
  }
  
  private void downSampleInput(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.maxRequired / paramInt2;
    int m = this.numChannels * paramInt2;
    int n = this.numChannels;
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      int i = 0;
      int j = 0;
      while (i < m)
      {
        j += paramArrayOfShort[(paramInt2 * m + paramInt1 * n + i)];
        i += 1;
      }
      i = j / m;
      this.downSampleBuffer[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void enlargeInputBufferIfNeeded(int paramInt)
  {
    if (this.numInputSamples + paramInt > this.inputBufferSize)
    {
      this.inputBufferSize += this.inputBufferSize / 2 + paramInt;
      this.inputBuffer = Arrays.copyOf(this.inputBuffer, this.inputBufferSize * this.numChannels);
    }
  }
  
  private void enlargeOutputBufferIfNeeded(int paramInt)
  {
    if (this.numOutputSamples + paramInt > this.outputBufferSize)
    {
      this.outputBufferSize += this.outputBufferSize / 2 + paramInt;
      this.outputBuffer = Arrays.copyOf(this.outputBuffer, this.outputBufferSize * this.numChannels);
    }
  }
  
  private int findPitchPeriod(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.inputSampleRateHz > 4000)
    {
      i = this.inputSampleRateHz / 4000;
      if ((this.numChannels != 1) || (i != 1)) {
        break label93;
      }
      paramInt = findPitchPeriodInRange(paramArrayOfShort, paramInt, this.minPeriod, this.maxPeriod);
    }
    for (;;)
    {
      label71:
      label93:
      int j;
      int k;
      if (previousPeriodBetter(this.minDiff, this.maxDiff, paramBoolean))
      {
        i = this.prevPeriod;
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = paramInt;
        return i;
        i = 1;
        break;
        downSampleInput(paramArrayOfShort, paramInt, i);
        j = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i, this.maxPeriod / i);
        if (i == 1) {
          break label249;
        }
        j *= i;
        k = j - i * 4;
        j += i * 4;
        if (k >= this.minPeriod) {
          break label242;
        }
      }
      label242:
      for (i = this.minPeriod;; i = k)
      {
        if (j > this.maxPeriod) {
          j = this.maxPeriod;
        }
        for (;;)
        {
          if (this.numChannels == 1)
          {
            paramInt = findPitchPeriodInRange(paramArrayOfShort, paramInt, i, j);
            break;
          }
          downSampleInput(paramArrayOfShort, paramInt, 1);
          paramInt = findPitchPeriodInRange(this.downSampleBuffer, 0, i, j);
          break;
          i = paramInt;
          break label71;
        }
      }
      label249:
      paramInt = j;
    }
  }
  
  private int findPitchPeriodInRange(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 255;
    int m = 1;
    int i2 = paramInt1 * this.numChannels;
    paramInt1 = paramInt2;
    int j = 0;
    int k = 0;
    int n;
    int i1;
    if (paramInt1 <= paramInt3)
    {
      n = 0;
      for (paramInt2 = 0; n < paramInt1; paramInt2 = i1 + paramInt2)
      {
        i1 = Math.abs(paramArrayOfShort[(i2 + n)] - paramArrayOfShort[(i2 + paramInt1 + n)]);
        n += 1;
      }
      i1 = m;
      n = k;
      if (paramInt2 * k < m * paramInt1)
      {
        i1 = paramInt2;
        n = paramInt1;
      }
      if (paramInt2 * i <= j * paramInt1) {
        break label155;
      }
      i = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      j = paramInt2;
      m = i1;
      k = n;
      break;
      this.minDiff = (m / k);
      this.maxDiff = (j / i);
      return k;
      label155:
      paramInt2 = j;
    }
  }
  
  private int insertPitchPeriod(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < 0.5F) {}
    for (int i = (int)(paramInt2 * paramFloat / (1.0F - paramFloat));; i = paramInt2)
    {
      enlargeOutputBufferIfNeeded(paramInt2 + i);
      System.arraycopy(paramArrayOfShort, this.numChannels * paramInt1, this.outputBuffer, this.numOutputSamples * this.numChannels, this.numChannels * paramInt2);
      overlapAdd(i, this.numChannels, this.outputBuffer, this.numOutputSamples + paramInt2, paramArrayOfShort, paramInt1 + paramInt2, paramArrayOfShort, paramInt1);
      this.numOutputSamples += paramInt2 + i;
      return i;
      this.remainingInputToCopy = ((int)(paramInt2 * (2.0F * paramFloat - 1.0F) / (1.0F - paramFloat)));
    }
  }
  
  private short interpolate(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfShort[paramInt1];
    paramInt1 = paramArrayOfShort[(this.numChannels + paramInt1)];
    int m = this.newRatePosition;
    int j = this.oldRatePosition;
    int k = (this.oldRatePosition + 1) * paramInt3;
    paramInt2 = k - m * paramInt2;
    paramInt3 = k - j * paramInt3;
    return (short)((i * paramInt2 + paramInt1 * (paramInt3 - paramInt2)) / paramInt3);
  }
  
  private void moveNewSamplesToPitchBuffer(int paramInt)
  {
    int i = this.numOutputSamples - paramInt;
    if (this.numPitchSamples + i > this.pitchBufferSize)
    {
      this.pitchBufferSize += this.pitchBufferSize / 2 + i;
      this.pitchBuffer = Arrays.copyOf(this.pitchBuffer, this.pitchBufferSize * this.numChannels);
    }
    System.arraycopy(this.outputBuffer, this.numChannels * paramInt, this.pitchBuffer, this.numPitchSamples * this.numChannels, this.numChannels * i);
    this.numOutputSamples = paramInt;
    this.numPitchSamples = (i + this.numPitchSamples);
  }
  
  private static void overlapAdd(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int n = paramInt3 * paramInt2 + i;
      int j = paramInt5 * paramInt2 + i;
      int m = paramInt4 * paramInt2 + i;
      int k = 0;
      while (k < paramInt1)
      {
        paramArrayOfShort1[n] = ((short)((paramArrayOfShort2[m] * (paramInt1 - k) + paramArrayOfShort3[j] * k) / paramInt1));
        n += paramInt2;
        m += paramInt2;
        j += paramInt2;
        k += 1;
      }
      i += 1;
    }
  }
  
  private boolean previousPeriodBetter(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 == 0) || (this.prevPeriod == 0)) {}
    do
    {
      return false;
      if (!paramBoolean) {
        break;
      }
    } while ((paramInt2 > paramInt1 * 3) || (paramInt1 * 2 <= this.prevMinDiff * 3));
    while (paramInt1 > this.prevMinDiff) {
      return true;
    }
    return false;
  }
  
  private void processStreamInput()
  {
    int i = this.numOutputSamples;
    float f1 = this.speed / this.pitch;
    float f2 = this.rate * this.pitch;
    if ((f1 > 1.00001D) || (f1 < 0.9999900000000001D)) {
      changeSpeed(f1);
    }
    for (;;)
    {
      if (f2 != 1.0F) {
        adjustRate(f2, i);
      }
      return;
      copyToOutput(this.inputBuffer, 0, this.numInputSamples);
      this.numInputSamples = 0;
    }
  }
  
  private void removePitchSamples(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    System.arraycopy(this.pitchBuffer, this.numChannels * paramInt, this.pitchBuffer, 0, (this.numPitchSamples - paramInt) * this.numChannels);
    this.numPitchSamples -= paramInt;
  }
  
  private void removeProcessedInputSamples(int paramInt)
  {
    int i = this.numInputSamples - paramInt;
    System.arraycopy(this.inputBuffer, this.numChannels * paramInt, this.inputBuffer, 0, this.numChannels * i);
    this.numInputSamples = i;
  }
  
  private int skipPitchPeriod(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat >= 2.0F) {}
    for (int i = (int)(paramInt2 / (paramFloat - 1.0F));; i = paramInt2)
    {
      enlargeOutputBufferIfNeeded(i);
      overlapAdd(i, this.numChannels, this.outputBuffer, this.numOutputSamples, paramArrayOfShort, paramInt1, paramArrayOfShort, paramInt1 + paramInt2);
      this.numOutputSamples += i;
      return i;
      this.remainingInputToCopy = ((int)(paramInt2 * (2.0F - paramFloat) / (paramFloat - 1.0F)));
    }
  }
  
  public void getOutput(ShortBuffer paramShortBuffer)
  {
    int i = Math.min(paramShortBuffer.remaining() / this.numChannels, this.numOutputSamples);
    paramShortBuffer.put(this.outputBuffer, 0, this.numChannels * i);
    this.numOutputSamples -= i;
    System.arraycopy(this.outputBuffer, i * this.numChannels, this.outputBuffer, 0, this.numOutputSamples * this.numChannels);
  }
  
  public int getSamplesAvailable()
  {
    return this.numOutputSamples;
  }
  
  public void queueEndOfStream()
  {
    int j = this.numInputSamples;
    float f1 = this.speed / this.pitch;
    float f2 = this.rate;
    float f3 = this.pitch;
    int k = this.numOutputSamples + (int)((j / f1 + this.numPitchSamples) / (f2 * f3) + 0.5F);
    enlargeInputBufferIfNeeded(this.maxRequired * 2 + j);
    int i = 0;
    while (i < this.maxRequired * 2 * this.numChannels)
    {
      this.inputBuffer[(this.numChannels * j + i)] = 0;
      i += 1;
    }
    this.numInputSamples += this.maxRequired * 2;
    processStreamInput();
    if (this.numOutputSamples > k) {
      this.numOutputSamples = k;
    }
    this.numInputSamples = 0;
    this.remainingInputToCopy = 0;
    this.numPitchSamples = 0;
  }
  
  public void queueInput(ShortBuffer paramShortBuffer)
  {
    int i = paramShortBuffer.remaining() / this.numChannels;
    int j = this.numChannels;
    enlargeInputBufferIfNeeded(i);
    paramShortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, j * i * 2 / 2);
    this.numInputSamples = (i + this.numInputSamples);
    processStreamInput();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.Sonic
 * JD-Core Version:    0.7.0.1
 */