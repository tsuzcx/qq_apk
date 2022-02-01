package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/CharCategory;", "", "value", "", "code", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getValue", "()I", "contains", "", "char", "", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum CharCategory
{
  public static final Companion Companion = new Companion(null);
  private static final Lazy categoryMap$delegate = LazyKt.lazy((Function0)CharCategory.Companion.categoryMap.2.INSTANCE);
  @NotNull
  private final String code;
  private final int value;
  
  static
  {
    CharCategory localCharCategory1 = new CharCategory("UNASSIGNED", 0, 0, "Cn");
    UNASSIGNED = localCharCategory1;
    CharCategory localCharCategory2 = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
    UPPERCASE_LETTER = localCharCategory2;
    CharCategory localCharCategory3 = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
    LOWERCASE_LETTER = localCharCategory3;
    CharCategory localCharCategory4 = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
    TITLECASE_LETTER = localCharCategory4;
    CharCategory localCharCategory5 = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
    MODIFIER_LETTER = localCharCategory5;
    CharCategory localCharCategory6 = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
    OTHER_LETTER = localCharCategory6;
    CharCategory localCharCategory7 = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
    NON_SPACING_MARK = localCharCategory7;
    CharCategory localCharCategory8 = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
    ENCLOSING_MARK = localCharCategory8;
    CharCategory localCharCategory9 = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
    COMBINING_SPACING_MARK = localCharCategory9;
    CharCategory localCharCategory10 = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
    DECIMAL_DIGIT_NUMBER = localCharCategory10;
    CharCategory localCharCategory11 = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
    LETTER_NUMBER = localCharCategory11;
    CharCategory localCharCategory12 = new CharCategory("OTHER_NUMBER", 11, 11, "No");
    OTHER_NUMBER = localCharCategory12;
    CharCategory localCharCategory13 = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
    SPACE_SEPARATOR = localCharCategory13;
    CharCategory localCharCategory14 = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
    LINE_SEPARATOR = localCharCategory14;
    CharCategory localCharCategory15 = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
    PARAGRAPH_SEPARATOR = localCharCategory15;
    CharCategory localCharCategory16 = new CharCategory("CONTROL", 15, 15, "Cc");
    CONTROL = localCharCategory16;
    CharCategory localCharCategory17 = new CharCategory("FORMAT", 16, 16, "Cf");
    FORMAT = localCharCategory17;
    CharCategory localCharCategory18 = new CharCategory("PRIVATE_USE", 17, 18, "Co");
    PRIVATE_USE = localCharCategory18;
    CharCategory localCharCategory19 = new CharCategory("SURROGATE", 18, 19, "Cs");
    SURROGATE = localCharCategory19;
    CharCategory localCharCategory20 = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
    DASH_PUNCTUATION = localCharCategory20;
    CharCategory localCharCategory21 = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
    START_PUNCTUATION = localCharCategory21;
    CharCategory localCharCategory22 = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
    END_PUNCTUATION = localCharCategory22;
    CharCategory localCharCategory23 = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
    CONNECTOR_PUNCTUATION = localCharCategory23;
    CharCategory localCharCategory24 = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
    OTHER_PUNCTUATION = localCharCategory24;
    CharCategory localCharCategory25 = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
    MATH_SYMBOL = localCharCategory25;
    CharCategory localCharCategory26 = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
    CURRENCY_SYMBOL = localCharCategory26;
    CharCategory localCharCategory27 = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
    MODIFIER_SYMBOL = localCharCategory27;
    CharCategory localCharCategory28 = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
    OTHER_SYMBOL = localCharCategory28;
    CharCategory localCharCategory29 = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
    INITIAL_QUOTE_PUNCTUATION = localCharCategory29;
    CharCategory localCharCategory30 = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
    FINAL_QUOTE_PUNCTUATION = localCharCategory30;
    $VALUES = new CharCategory[] { localCharCategory1, localCharCategory2, localCharCategory3, localCharCategory4, localCharCategory5, localCharCategory6, localCharCategory7, localCharCategory8, localCharCategory9, localCharCategory10, localCharCategory11, localCharCategory12, localCharCategory13, localCharCategory14, localCharCategory15, localCharCategory16, localCharCategory17, localCharCategory18, localCharCategory19, localCharCategory20, localCharCategory21, localCharCategory22, localCharCategory23, localCharCategory24, localCharCategory25, localCharCategory26, localCharCategory27, localCharCategory28, localCharCategory29, localCharCategory30 };
  }
  
  private CharCategory(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.code = paramString;
  }
  
  public final boolean contains(char paramChar)
  {
    return Character.getType(paramChar) == this.value;
  }
  
  @NotNull
  public final String getCode()
  {
    return this.code;
  }
  
  public final int getValue()
  {
    return this.value;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/CharCategory$Companion;", "", "()V", "categoryMap", "", "", "Lkotlin/text/CharCategory;", "getCategoryMap", "()Ljava/util/Map;", "categoryMap$delegate", "Lkotlin/Lazy;", "valueOf", "category", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final Map<Integer, CharCategory> getCategoryMap()
    {
      Lazy localLazy = CharCategory.access$getCategoryMap$cp();
      Companion localCompanion = CharCategory.Companion;
      return (Map)localLazy.getValue();
    }
    
    @NotNull
    public final CharCategory valueOf(int paramInt)
    {
      CharCategory localCharCategory = (CharCategory)((Companion)this).getCategoryMap().get(Integer.valueOf(paramInt));
      if (localCharCategory != null) {
        return localCharCategory;
      }
      throw ((Throwable)new IllegalArgumentException("Category #" + paramInt + " is not defined."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.CharCategory
 * JD-Core Version:    0.7.0.1
 */