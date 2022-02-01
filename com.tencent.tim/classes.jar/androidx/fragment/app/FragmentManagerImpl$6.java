package androidx.fragment.app;

import androidx.annotation.NonNull;

class FragmentManagerImpl$6
  extends FragmentFactory
{
  FragmentManagerImpl$6(FragmentManagerImpl paramFragmentManagerImpl) {}
  
  @NonNull
  public Fragment instantiate(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    return this.this$0.mHost.instantiate(this.this$0.mHost.getContext(), paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */