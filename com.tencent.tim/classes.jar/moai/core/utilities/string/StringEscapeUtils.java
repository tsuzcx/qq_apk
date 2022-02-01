package moai.core.utilities.string;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import com.google.common.escape.Escapers.Builder;
import java.lang.reflect.Array;

class StringEscapeUtils
{
  private static final String[][] BASIC_ESCAPE = { { "\"", "&quot;" }, { "&", "&amp;" }, { "<", "&lt;" }, { ">", "&gt;" } };
  private static final Escaper ESCAPER = initEscaper();
  private static final String[][] HTML40_EXTENDED_ESCAPE;
  private static final String[][] ISO8859_1_ESCAPE;
  public static final CharSequenceTranslator UNESCAPE_HTML4 = new AggregateTranslator(new CharSequenceTranslator[] { new LookupTranslator(invert(BASIC_ESCAPE)), new LookupTranslator(invert(ISO8859_1_ESCAPE)), new LookupTranslator(invert(HTML40_EXTENDED_ESCAPE)), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
  
  static
  {
    String[] arrayOfString1 = { "¡", "&iexcl;" };
    String[] arrayOfString2 = { "£", "&pound;" };
    String[] arrayOfString3 = { "¤", "&curren;" };
    String[] arrayOfString4 = { "¥", "&yen;" };
    String[] arrayOfString5 = { "¦", "&brvbar;" };
    String[] arrayOfString6 = { "§", "&sect;" };
    String[] arrayOfString7 = { "©", "&copy;" };
    String[] arrayOfString8 = { "¬", "&not;" };
    String[] arrayOfString9 = { "­", "&shy;" };
    String[] arrayOfString10 = { "¯", "&macr;" };
    String[] arrayOfString11 = { "°", "&deg;" };
    String[] arrayOfString12 = { "±", "&plusmn;" };
    String[] arrayOfString13 = { "²", "&sup2;" };
    String[] arrayOfString14 = { "³", "&sup3;" };
    String[] arrayOfString15 = { "µ", "&micro;" };
    String[] arrayOfString16 = { "¶", "&para;" };
    String[] arrayOfString17 = { "·", "&middot;" };
    String[] arrayOfString18 = { "¹", "&sup1;" };
    String[] arrayOfString19 = { "º", "&ordm;" };
    String[] arrayOfString20 = { "»", "&raquo;" };
    String[] arrayOfString21 = { "¾", "&frac34;" };
    String[] arrayOfString22 = { "¿", "&iquest;" };
    String[] arrayOfString23 = { "À", "&Agrave;" };
    String[] arrayOfString24 = { "Á", "&Aacute;" };
    String[] arrayOfString25 = { "Ã", "&Atilde;" };
    String[] arrayOfString26 = { "Ä", "&Auml;" };
    String[] arrayOfString27 = { "Å", "&Aring;" };
    String[] arrayOfString28 = { "Ç", "&Ccedil;" };
    String[] arrayOfString29 = { "È", "&Egrave;" };
    String[] arrayOfString30 = { "Ê", "&Ecirc;" };
    String[] arrayOfString31 = { "Ë", "&Euml;" };
    String[] arrayOfString32 = { "Ì", "&Igrave;" };
    String[] arrayOfString33 = { "Í", "&Iacute;" };
    String[] arrayOfString34 = { "Î", "&Icirc;" };
    String[] arrayOfString35 = { "Ð", "&ETH;" };
    String[] arrayOfString36 = { "Ñ", "&Ntilde;" };
    String[] arrayOfString37 = { "Ò", "&Ograve;" };
    String[] arrayOfString38 = { "Ó", "&Oacute;" };
    String[] arrayOfString39 = { "Ö", "&Ouml;" };
    String[] arrayOfString40 = { "Ø", "&Oslash;" };
    String[] arrayOfString41 = { "Ù", "&Ugrave;" };
    String[] arrayOfString42 = { "Ü", "&Uuml;" };
    String[] arrayOfString43 = { "Ý", "&Yacute;" };
    String[] arrayOfString44 = { "Þ", "&THORN;" };
    String[] arrayOfString45 = { "ß", "&szlig;" };
    String[] arrayOfString46 = { "à", "&agrave;" };
    String[] arrayOfString47 = { "â", "&acirc;" };
    String[] arrayOfString48 = { "ä", "&auml;" };
    String[] arrayOfString49 = { "å", "&aring;" };
    String[] arrayOfString50 = { "æ", "&aelig;" };
    String[] arrayOfString51 = { "é", "&eacute;" };
    String[] arrayOfString52 = { "ë", "&euml;" };
    String[] arrayOfString53 = { "ì", "&igrave;" };
    String[] arrayOfString54 = { "í", "&iacute;" };
    String[] arrayOfString55 = { "ð", "&eth;" };
    String[] arrayOfString56 = { "ñ", "&ntilde;" };
    String[] arrayOfString57 = { "ò", "&ograve;" };
    String[] arrayOfString58 = { "ó", "&oacute;" };
    String[] arrayOfString59 = { "õ", "&otilde;" };
    String[] arrayOfString60 = { "ö", "&ouml;" };
    String[] arrayOfString61 = { "ø", "&oslash;" };
    String[] arrayOfString62 = { "ú", "&uacute;" };
    String[] arrayOfString63 = { "û", "&ucirc;" };
    String[] arrayOfString64 = { "ý", "&yacute;" };
    String[] arrayOfString65 = { "þ", "&thorn;" };
    String[] arrayOfString66 = { "ÿ", "&yuml;" };
    ISO8859_1_ESCAPE = new String[][] { { " ", "&nbsp;" }, arrayOfString1, { "¢", "&cent;" }, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, { "¨", "&uml;" }, arrayOfString7, { "ª", "&ordf;" }, { "«", "&laquo;" }, arrayOfString8, arrayOfString9, { "®", "&reg;" }, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, { "´", "&acute;" }, arrayOfString15, arrayOfString16, arrayOfString17, { "¸", "&cedil;" }, arrayOfString18, arrayOfString19, arrayOfString20, { "¼", "&frac14;" }, { "½", "&frac12;" }, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, { "Â", "&Acirc;" }, arrayOfString25, arrayOfString26, arrayOfString27, { "Æ", "&AElig;" }, arrayOfString28, arrayOfString29, { "É", "&Eacute;" }, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, { "Ï", "&Iuml;" }, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, { "Ô", "&Ocirc;" }, { "Õ", "&Otilde;" }, arrayOfString39, { "×", "&times;" }, arrayOfString40, arrayOfString41, { "Ú", "&Uacute;" }, { "Û", "&Ucirc;" }, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, { "á", "&aacute;" }, arrayOfString47, { "ã", "&atilde;" }, arrayOfString48, arrayOfString49, arrayOfString50, { "ç", "&ccedil;" }, { "è", "&egrave;" }, arrayOfString51, { "ê", "&ecirc;" }, arrayOfString52, arrayOfString53, arrayOfString54, { "î", "&icirc;" }, { "ï", "&iuml;" }, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, { "ô", "&ocirc;" }, arrayOfString59, arrayOfString60, { "÷", "&divide;" }, arrayOfString61, { "ù", "&ugrave;" }, arrayOfString62, arrayOfString63, { "ü", "&uuml;" }, arrayOfString64, arrayOfString65, arrayOfString66 };
    arrayOfString1 = new String[] { "ƒ", "&fnof;" };
    arrayOfString2 = new String[] { "Α", "&Alpha;" };
    arrayOfString3 = new String[] { "Β", "&Beta;" };
    arrayOfString4 = new String[] { "Γ", "&Gamma;" };
    arrayOfString5 = new String[] { "Δ", "&Delta;" };
    arrayOfString6 = new String[] { "Ε", "&Epsilon;" };
    arrayOfString7 = new String[] { "Η", "&Eta;" };
    arrayOfString8 = new String[] { "Ι", "&Iota;" };
    arrayOfString9 = new String[] { "Κ", "&Kappa;" };
    arrayOfString10 = new String[] { "Λ", "&Lambda;" };
    arrayOfString11 = new String[] { "Μ", "&Mu;" };
    arrayOfString12 = new String[] { "Ο", "&Omicron;" };
    arrayOfString13 = new String[] { "Π", "&Pi;" };
    arrayOfString14 = new String[] { "Ρ", "&Rho;" };
    arrayOfString15 = new String[] { "Τ", "&Tau;" };
    arrayOfString16 = new String[] { "Υ", "&Upsilon;" };
    arrayOfString17 = new String[] { "Χ", "&Chi;" };
    arrayOfString18 = new String[] { "Ψ", "&Psi;" };
    arrayOfString19 = new String[] { "Ω", "&Omega;" };
    arrayOfString20 = new String[] { "α", "&alpha;" };
    arrayOfString21 = new String[] { "γ", "&gamma;" };
    arrayOfString22 = new String[] { "δ", "&delta;" };
    arrayOfString23 = new String[] { "ε", "&epsilon;" };
    arrayOfString24 = new String[] { "η", "&eta;" };
    arrayOfString25 = new String[] { "θ", "&theta;" };
    arrayOfString26 = new String[] { "ι", "&iota;" };
    arrayOfString27 = new String[] { "λ", "&lambda;" };
    arrayOfString28 = new String[] { "ν", "&nu;" };
    arrayOfString29 = new String[] { "ξ", "&xi;" };
    arrayOfString30 = new String[] { "ο", "&omicron;" };
    arrayOfString31 = new String[] { "π", "&pi;" };
    arrayOfString32 = new String[] { "σ", "&sigma;" };
    arrayOfString33 = new String[] { "τ", "&tau;" };
    arrayOfString34 = new String[] { "υ", "&upsilon;" };
    arrayOfString35 = new String[] { "φ", "&phi;" };
    arrayOfString36 = new String[] { "ω", "&omega;" };
    arrayOfString37 = new String[] { "ϑ", "&thetasym;" };
    arrayOfString38 = new String[] { "ϒ", "&upsih;" };
    arrayOfString39 = new String[] { "ϖ", "&piv;" };
    arrayOfString40 = new String[] { "•", "&bull;" };
    arrayOfString41 = new String[] { "′", "&prime;" };
    arrayOfString42 = new String[] { "‾", "&oline;" };
    arrayOfString43 = new String[] { "⁄", "&frasl;" };
    arrayOfString44 = new String[] { "℘", "&weierp;" };
    arrayOfString45 = new String[] { "ℵ", "&alefsym;" };
    arrayOfString46 = new String[] { "←", "&larr;" };
    arrayOfString47 = new String[] { "↑", "&uarr;" };
    arrayOfString48 = new String[] { "→", "&rarr;" };
    arrayOfString49 = new String[] { "↔", "&harr;" };
    arrayOfString50 = new String[] { "↵", "&crarr;" };
    arrayOfString51 = new String[] { "⇐", "&lArr;" };
    arrayOfString52 = new String[] { "⇑", "&uArr;" };
    arrayOfString53 = new String[] { "⇒", "&rArr;" };
    arrayOfString54 = new String[] { "⇓", "&dArr;" };
    arrayOfString55 = new String[] { "⇔", "&hArr;" };
    arrayOfString56 = new String[] { "∂", "&part;" };
    arrayOfString57 = new String[] { "∃", "&exist;" };
    arrayOfString58 = new String[] { "∅", "&empty;" };
    arrayOfString59 = new String[] { "∈", "&isin;" };
    arrayOfString60 = new String[] { "∉", "&notin;" };
    arrayOfString61 = new String[] { "∏", "&prod;" };
    arrayOfString62 = new String[] { "∑", "&sum;" };
    arrayOfString63 = new String[] { "−", "&minus;" };
    arrayOfString64 = new String[] { "∗", "&lowast;" };
    arrayOfString65 = new String[] { "√", "&radic;" };
    arrayOfString66 = new String[] { "∝", "&prop;" };
    String[] arrayOfString67 = { "∠", "&ang;" };
    String[] arrayOfString68 = { "∧", "&and;" };
    String[] arrayOfString69 = { "∨", "&or;" };
    String[] arrayOfString70 = { "∪", "&cup;" };
    String[] arrayOfString71 = { "∴", "&there4;" };
    String[] arrayOfString72 = { "∼", "&sim;" };
    String[] arrayOfString73 = { "≠", "&ne;" };
    String[] arrayOfString74 = { "≡", "&equiv;" };
    String[] arrayOfString75 = { "≤", "&le;" };
    String[] arrayOfString76 = { "≥", "&ge;" };
    String[] arrayOfString77 = { "⊂", "&sub;" };
    String[] arrayOfString78 = { "⊃", "&sup;" };
    String[] arrayOfString79 = { "⊇", "&supe;" };
    String[] arrayOfString80 = { "⊕", "&oplus;" };
    String[] arrayOfString81 = { "⊗", "&otimes;" };
    String[] arrayOfString82 = { "⊥", "&perp;" };
    String[] arrayOfString83 = { "⋅", "&sdot;" };
    String[] arrayOfString84 = { "⌈", "&lceil;" };
    String[] arrayOfString85 = { "⌊", "&lfloor;" };
    String[] arrayOfString86 = { "⌋", "&rfloor;" };
    String[] arrayOfString87 = { "〈", "&lang;" };
    String[] arrayOfString88 = { "◊", "&loz;" };
    String[] arrayOfString89 = { "♣", "&clubs;" };
    String[] arrayOfString90 = { "♥", "&hearts;" };
    String[] arrayOfString91 = { "♦", "&diams;" };
    String[] arrayOfString92 = { "œ", "&oelig;" };
    String[] arrayOfString93 = { "Š", "&Scaron;" };
    String[] arrayOfString94 = { "š", "&scaron;" };
    String[] arrayOfString95 = { "Ÿ", "&Yuml;" };
    String[] arrayOfString96 = { "˜", "&tilde;" };
    String[] arrayOfString97 = { " ", "&ensp;" };
    String[] arrayOfString98 = { " ", "&emsp;" };
    String[] arrayOfString99 = { " ", "&thinsp;" };
    String[] arrayOfString100 = { "‍", "&zwj;" };
    String[] arrayOfString101 = { "‏", "&rlm;" };
    String[] arrayOfString102 = { "’", "&rsquo;" };
    String[] arrayOfString103 = { "‚", "&sbquo;" };
    String[] arrayOfString104 = { "“", "&ldquo;" };
    String[] arrayOfString105 = { "”", "&rdquo;" };
    String[] arrayOfString106 = { "„", "&bdquo;" };
    String[] arrayOfString107 = { "‰", "&permil;" };
    String[] arrayOfString108 = { "‹", "&lsaquo;" };
    String[] arrayOfString109 = { "›", "&rsaquo;" };
    HTML40_EXTENDED_ESCAPE = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, { "Ζ", "&Zeta;" }, arrayOfString7, { "Θ", "&Theta;" }, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "Ν", "&Nu;" }, { "Ξ", "&Xi;" }, arrayOfString12, arrayOfString13, arrayOfString14, { "Σ", "&Sigma;" }, arrayOfString15, arrayOfString16, { "Φ", "&Phi;" }, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, { "β", "&beta;" }, arrayOfString21, arrayOfString22, arrayOfString23, { "ζ", "&zeta;" }, arrayOfString24, arrayOfString25, arrayOfString26, { "κ", "&kappa;" }, arrayOfString27, { "μ", "&mu;" }, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, { "ρ", "&rho;" }, { "ς", "&sigmaf;" }, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, { "χ", "&chi;" }, { "ψ", "&psi;" }, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, { "…", "&hellip;" }, arrayOfString41, { "″", "&Prime;" }, arrayOfString42, arrayOfString43, arrayOfString44, { "ℑ", "&image;" }, { "ℜ", "&real;" }, { "™", "&trade;" }, arrayOfString45, arrayOfString46, arrayOfString47, arrayOfString48, { "↓", "&darr;" }, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, { "∀", "&forall;" }, arrayOfString56, arrayOfString57, arrayOfString58, { "∇", "&nabla;" }, arrayOfString59, arrayOfString60, { "∋", "&ni;" }, arrayOfString61, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, { "∞", "&infin;" }, arrayOfString67, arrayOfString68, arrayOfString69, { "∩", "&cap;" }, arrayOfString70, { "∫", "&int;" }, arrayOfString71, arrayOfString72, { "≅", "&cong;" }, { "≈", "&asymp;" }, arrayOfString73, arrayOfString74, arrayOfString75, arrayOfString76, arrayOfString77, arrayOfString78, { "⊆", "&sube;" }, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83, arrayOfString84, { "⌉", "&rceil;" }, arrayOfString85, arrayOfString86, arrayOfString87, { "〉", "&rang;" }, arrayOfString88, { "♠", "&spades;" }, arrayOfString89, arrayOfString90, arrayOfString91, { "Œ", "&OElig;" }, arrayOfString92, arrayOfString93, arrayOfString94, arrayOfString95, { "ˆ", "&circ;" }, arrayOfString96, arrayOfString97, arrayOfString98, arrayOfString99, { "‌", "&zwnj;" }, arrayOfString100, { "‎", "&lrm;" }, arrayOfString101, { "–", "&ndash;" }, { "—", "&mdash;" }, { "‘", "&lsquo;" }, arrayOfString102, arrayOfString103, arrayOfString104, arrayOfString105, arrayOfString106, { "†", "&dagger;" }, { "‡", "&Dagger;" }, arrayOfString107, arrayOfString108, arrayOfString109, { "€", "&euro;" } };
  }
  
  public static final String escapeHtml4(String paramString)
  {
    return ESCAPER.escape(paramString);
  }
  
  private static Escaper initEscaper()
  {
    Escapers.Builder localBuilder = Escapers.builder();
    String[][] arrayOfString = BASIC_ESCAPE;
    int j = arrayOfString.length;
    int i = 0;
    String[] arrayOfString1;
    while (i < j)
    {
      arrayOfString1 = arrayOfString[i];
      localBuilder.addEscape(arrayOfString1[0].charAt(0), arrayOfString1[1]);
      i += 1;
    }
    arrayOfString = ISO8859_1_ESCAPE;
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      arrayOfString1 = arrayOfString[i];
      localBuilder.addEscape(arrayOfString1[0].charAt(0), arrayOfString1[1]);
      i += 1;
    }
    arrayOfString = HTML40_EXTENDED_ESCAPE;
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      arrayOfString1 = arrayOfString[i];
      localBuilder.addEscape(arrayOfString1[0].charAt(0), arrayOfString1[1]);
      i += 1;
    }
    return localBuilder.build();
  }
  
  public static String[][] invert(String[][] paramArrayOfString)
  {
    String[][] arrayOfString = (String[][])Array.newInstance(String.class, new int[] { paramArrayOfString.length, 2 });
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfString[i][0] = paramArrayOfString[i][1];
      arrayOfString[i][1] = paramArrayOfString[i][0];
      i += 1;
    }
    return arrayOfString;
  }
  
  public static final String unescapeHtml4(String paramString)
  {
    return UNESCAPE_HTML4.translate(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.string.StringEscapeUtils
 * JD-Core Version:    0.7.0.1
 */