package moai.rx;

import java.util.concurrent.TimeUnit;
import rx.Observable;

public class TransformDelayShareTo<K, T>
  extends TransformerShareTo<K, T>
{
  private static final int DELAY_IN_SECOND = 10;
  private static final String NAME_PREFIX = "cached_";
  
  public TransformDelayShareTo(K paramK)
  {
    this("Default", paramK);
  }
  
  public TransformDelayShareTo(String paramString, K paramK)
  {
    super("cached_" + paramString, paramK);
  }
  
  protected void invalidateKey(Object paramObject)
  {
    Observable.create(new TransformDelayShareTo.1(this, paramObject)).delaySubscription(10L, TimeUnit.SECONDS).subscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformDelayShareTo
 * JD-Core Version:    0.7.0.1
 */