package androidx.core.text;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.Layout.Alignment;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat
  implements Spannable
{
  private static final char LINE_FEED = '\n';
  @GuardedBy("sLock")
  @NonNull
  private static Executor sExecutor = null;
  private static final Object sLock = new Object();
  @NonNull
  private final int[] mParagraphEnds;
  @NonNull
  private final Params mParams;
  @NonNull
  private final Spannable mText;
  @Nullable
  private final PrecomputedText mWrapped;
  
  @RequiresApi(28)
  private PrecomputedTextCompat(@NonNull PrecomputedText paramPrecomputedText, @NonNull Params paramParams)
  {
    this.mText = paramPrecomputedText;
    this.mParams = paramParams;
    this.mParagraphEnds = null;
    this.mWrapped = null;
  }
  
  private PrecomputedTextCompat(@NonNull CharSequence paramCharSequence, @NonNull Params paramParams, @NonNull int[] paramArrayOfInt)
  {
    this.mText = new SpannableString(paramCharSequence);
    this.mParams = paramParams;
    this.mParagraphEnds = paramArrayOfInt;
    this.mWrapped = null;
  }
  
  public static PrecomputedTextCompat create(@NonNull CharSequence paramCharSequence, @NonNull Params paramParams)
  {
    Preconditions.checkNotNull(paramCharSequence);
    Preconditions.checkNotNull(paramParams);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        TraceCompat.beginSection("PrecomputedText");
        localArrayList = new ArrayList();
        int j = paramCharSequence.length();
        i = 0;
        if (i >= j) {
          break;
        }
        i = TextUtils.indexOf(paramCharSequence, '\n', i, j);
        if (i < 0)
        {
          i = j;
          localArrayList.add(Integer.valueOf(i));
        }
        else
        {
          i += 1;
        }
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramParams.getTextPaint(), 2147483647).setBreakStrategy(paramParams.getBreakStrategy()).setHyphenationFrequency(paramParams.getHyphenationFrequency()).setTextDirection(paramParams.getTextDirection()).build();
    }
    for (;;)
    {
      paramCharSequence = new PrecomputedTextCompat(paramCharSequence, paramParams, arrayOfInt);
      TraceCompat.endSection();
      return paramCharSequence;
      if (Build.VERSION.SDK_INT >= 21) {
        new StaticLayout(paramCharSequence, paramParams.getTextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      }
    }
  }
  
  @UiThread
  public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence paramCharSequence, @NonNull Params paramParams, @Nullable Executor arg2)
  {
    paramParams = new PrecomputedTextFutureTask(paramParams, paramCharSequence);
    paramCharSequence = ???;
    if (??? == null) {}
    synchronized (sLock)
    {
      if (sExecutor == null) {
        sExecutor = Executors.newFixedThreadPool(1);
      }
      paramCharSequence = sExecutor;
      paramCharSequence.execute(paramParams);
      return paramParams;
    }
  }
  
  public char charAt(int paramInt)
  {
    return this.mText.charAt(paramInt);
  }
  
  @IntRange(from=0L)
  public int getParagraphCount()
  {
    return this.mParagraphEnds.length;
  }
  
  @IntRange(from=0L)
  public int getParagraphEnd(@IntRange(from=0L) int paramInt)
  {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    return this.mParagraphEnds[paramInt];
  }
  
  @IntRange(from=0L)
  public int getParagraphStart(@IntRange(from=0L) int paramInt)
  {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    if (paramInt == 0) {
      return 0;
    }
    return this.mParagraphEnds[(paramInt - 1)];
  }
  
  @NonNull
  public Params getParams()
  {
    return this.mParams;
  }
  
  @Nullable
  @RequiresApi(28)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PrecomputedText getPrecomputedText()
  {
    if ((this.mText instanceof PrecomputedText)) {
      return (PrecomputedText)this.mText;
    }
    return null;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    return this.mText.getSpanEnd(paramObject);
  }
  
  public int getSpanFlags(Object paramObject)
  {
    return this.mText.getSpanFlags(paramObject);
  }
  
  public int getSpanStart(Object paramObject)
  {
    return this.mText.getSpanStart(paramObject);
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    return this.mText.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public int length()
  {
    return this.mText.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.mText.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    this.mText.removeSpan(paramObject);
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    this.mText.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.mText.subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.mText.toString();
  }
  
  public static final class Params
  {
    private final int mBreakStrategy;
    private final int mHyphenationFrequency;
    @NonNull
    private final TextPaint mPaint;
    @Nullable
    private final TextDirectionHeuristic mTextDir;
    final PrecomputedText.Params mWrapped;
    
    @RequiresApi(28)
    public Params(@NonNull PrecomputedText.Params paramParams)
    {
      this.mPaint = paramParams.getTextPaint();
      this.mTextDir = paramParams.getTextDirection();
      this.mBreakStrategy = paramParams.getBreakStrategy();
      this.mHyphenationFrequency = paramParams.getHyphenationFrequency();
      this.mWrapped = null;
    }
    
    Params(@NonNull TextPaint paramTextPaint, @NonNull TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      this.mWrapped = null;
      this.mPaint = paramTextPaint;
      this.mTextDir = paramTextDirectionHeuristic;
      this.mBreakStrategy = paramInt1;
      this.mHyphenationFrequency = paramInt2;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof Params)) {
          return false;
        }
        paramObject = (Params)paramObject;
        if (!equalsWithoutTextDirection(paramObject)) {
          return false;
        }
      } while ((Build.VERSION.SDK_INT < 18) || (this.mTextDir == paramObject.getTextDirection()));
      return false;
    }
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean equalsWithoutTextDirection(@NonNull Params paramParams)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this.mWrapped != null) {
        bool1 = this.mWrapped.equals(paramParams.mWrapped);
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return bool1;
                          if (Build.VERSION.SDK_INT < 23) {
                            break;
                          }
                          bool1 = bool2;
                        } while (this.mBreakStrategy != paramParams.getBreakStrategy());
                        bool1 = bool2;
                      } while (this.mHyphenationFrequency != paramParams.getHyphenationFrequency());
                      bool1 = bool2;
                    } while (this.mPaint.getTextSize() != paramParams.getTextPaint().getTextSize());
                    bool1 = bool2;
                  } while (this.mPaint.getTextScaleX() != paramParams.getTextPaint().getTextScaleX());
                  bool1 = bool2;
                } while (this.mPaint.getTextSkewX() != paramParams.getTextPaint().getTextSkewX());
                if (Build.VERSION.SDK_INT < 21) {
                  break;
                }
                bool1 = bool2;
              } while (this.mPaint.getLetterSpacing() != paramParams.getTextPaint().getLetterSpacing());
              bool1 = bool2;
            } while (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), paramParams.getTextPaint().getFontFeatureSettings()));
            bool1 = bool2;
          } while (this.mPaint.getFlags() != paramParams.getTextPaint().getFlags());
          if (Build.VERSION.SDK_INT < 24) {
            break;
          }
          bool1 = bool2;
        } while (!this.mPaint.getTextLocales().equals(paramParams.getTextPaint().getTextLocales()));
        if (this.mPaint.getTypeface() != null) {
          break label270;
        }
        bool1 = bool2;
      } while (paramParams.getTextPaint().getTypeface() != null);
      label270:
      while (this.mPaint.getTypeface().equals(paramParams.getTextPaint().getTypeface()))
      {
        return true;
        if ((Build.VERSION.SDK_INT < 17) || (this.mPaint.getTextLocale().equals(paramParams.getTextPaint().getTextLocale()))) {
          break;
        }
        return false;
      }
      return false;
    }
    
    @RequiresApi(23)
    public int getBreakStrategy()
    {
      return this.mBreakStrategy;
    }
    
    @RequiresApi(23)
    public int getHyphenationFrequency()
    {
      return this.mHyphenationFrequency;
    }
    
    @Nullable
    @RequiresApi(18)
    public TextDirectionHeuristic getTextDirection()
    {
      return this.mTextDir;
    }
    
    @NonNull
    public TextPaint getTextPaint()
    {
      return this.mPaint;
    }
    
    public int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
      }
      if (Build.VERSION.SDK_INT >= 21) {
        return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
      }
      if (Build.VERSION.SDK_INT >= 18) {
        return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
      }
      if (Build.VERSION.SDK_INT >= 17) {
        return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
      }
      return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.mPaint.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.mPaint.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.mPaint.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocales());
      }
      for (;;)
      {
        localStringBuilder.append(", typeface=" + this.mPaint.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          localStringBuilder.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        }
        localStringBuilder.append(", textDir=" + this.mTextDir);
        localStringBuilder.append(", breakStrategy=" + this.mBreakStrategy);
        localStringBuilder.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17) {
          localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocale());
        }
      }
    }
    
    public static class Builder
    {
      private int mBreakStrategy;
      private int mHyphenationFrequency;
      @NonNull
      private final TextPaint mPaint;
      private TextDirectionHeuristic mTextDir;
      
      public Builder(@NonNull TextPaint paramTextPaint)
      {
        this.mPaint = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.mBreakStrategy = 1;
          this.mHyphenationFrequency = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.mHyphenationFrequency = 0;
          this.mBreakStrategy = 0;
        }
        this.mTextDir = null;
      }
      
      @NonNull
      public PrecomputedTextCompat.Params build()
      {
        return new PrecomputedTextCompat.Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
      }
      
      @RequiresApi(23)
      public Builder setBreakStrategy(int paramInt)
      {
        this.mBreakStrategy = paramInt;
        return this;
      }
      
      @RequiresApi(23)
      public Builder setHyphenationFrequency(int paramInt)
      {
        this.mHyphenationFrequency = paramInt;
        return this;
      }
      
      @RequiresApi(18)
      public Builder setTextDirection(@NonNull TextDirectionHeuristic paramTextDirectionHeuristic)
      {
        this.mTextDir = paramTextDirectionHeuristic;
        return this;
      }
    }
  }
  
  static class PrecomputedTextFutureTask
    extends FutureTask<PrecomputedTextCompat>
  {
    PrecomputedTextFutureTask(@NonNull PrecomputedTextCompat.Params paramParams, @NonNull CharSequence paramCharSequence)
    {
      super();
    }
    
    static class PrecomputedTextCallback
      implements Callable<PrecomputedTextCompat>
    {
      private PrecomputedTextCompat.Params mParams;
      private CharSequence mText;
      
      PrecomputedTextCallback(@NonNull PrecomputedTextCompat.Params paramParams, @NonNull CharSequence paramCharSequence)
      {
        this.mParams = paramParams;
        this.mText = paramCharSequence;
      }
      
      public PrecomputedTextCompat call()
        throws Exception
      {
        return PrecomputedTextCompat.create(this.mText, this.mParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.text.PrecomputedTextCompat
 * JD-Core Version:    0.7.0.1
 */