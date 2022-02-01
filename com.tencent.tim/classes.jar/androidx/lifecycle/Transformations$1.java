package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

final class Transformations$1
  implements Observer<X>
{
  Transformations$1(MediatorLiveData paramMediatorLiveData, Function paramFunction) {}
  
  public void onChanged(@Nullable X paramX)
  {
    this.val$result.setValue(this.val$mapFunction.apply(paramX));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.Transformations.1
 * JD-Core Version:    0.7.0.1
 */