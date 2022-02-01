package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="CharsetsKt")
public final class CharsetsKt
{
  @InlineOnly
  private static final Charset charset(String paramString)
  {
    paramString = Charset.forName(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Charset.forName(charsetName)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.CharsetsKt
 * JD-Core Version:    0.7.0.1
 */