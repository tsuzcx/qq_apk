package moai.io;

import android.graphics.Typeface;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.common.cache.CacheLoader;

final class Caches$1
  extends CacheLoader<Typeface, Pair<SparseIntArray, SparseIntArray>>
{
  public Pair<SparseIntArray, SparseIntArray> load(Typeface paramTypeface)
    throws Exception
  {
    return Pair.create(new SparseIntArray(), new SparseIntArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.Caches.1
 * JD-Core Version:    0.7.0.1
 */