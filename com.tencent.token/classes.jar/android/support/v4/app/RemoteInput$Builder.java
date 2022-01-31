package android.support.v4.app;

import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public final class RemoteInput$Builder
{
  private boolean mAllowFreeFormTextInput = true;
  private final Set mAllowedDataTypes = new HashSet();
  private CharSequence[] mChoices;
  private Bundle mExtras = new Bundle();
  private CharSequence mLabel;
  private final String mResultKey;
  
  public RemoteInput$Builder(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Result key can't be null");
    }
    this.mResultKey = paramString;
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mExtras.putAll(paramBundle);
    }
    return this;
  }
  
  public RemoteInput build()
  {
    return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mExtras, this.mAllowedDataTypes);
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public Builder setAllowDataType(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mAllowedDataTypes.add(paramString);
      return this;
    }
    this.mAllowedDataTypes.remove(paramString);
    return this;
  }
  
  public Builder setAllowFreeFormInput(boolean paramBoolean)
  {
    this.mAllowFreeFormTextInput = paramBoolean;
    return this;
  }
  
  public Builder setChoices(CharSequence[] paramArrayOfCharSequence)
  {
    this.mChoices = paramArrayOfCharSequence;
    return this;
  }
  
  public Builder setLabel(CharSequence paramCharSequence)
  {
    this.mLabel = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.RemoteInput.Builder
 * JD-Core Version:    0.7.0.1
 */