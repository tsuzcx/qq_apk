package org.apache.commons.lang3.text.translate;

import java.lang.reflect.Array;

public class EntityArrays
{
  private static final String[][] APOS_ESCAPE;
  private static final String[][] APOS_UNESCAPE;
  private static final String[][] BASIC_ESCAPE;
  private static final String[][] BASIC_UNESCAPE;
  private static final String[][] HTML40_EXTENDED_ESCAPE;
  private static final String[][] HTML40_EXTENDED_UNESCAPE;
  private static final String[][] ISO8859_1_ESCAPE;
  private static final String[][] ISO8859_1_UNESCAPE;
  private static final String[][] JAVA_CTRL_CHARS_ESCAPE;
  private static final String[][] JAVA_CTRL_CHARS_UNESCAPE = invert(JAVA_CTRL_CHARS_ESCAPE);
  
  static
  {
    String[] arrayOfString1 = { "¶", "&para;" };
    String[] arrayOfString2 = { "¼", "&frac14;" };
    String[] arrayOfString3 = { "¿", "&iquest;" };
    String[] arrayOfString4 = { "Ü", "&Uuml;" };
    String[] arrayOfString5 = { "ô", "&ocirc;" };
    String[] arrayOfString6 = { "÷", "&divide;" };
    String[] arrayOfString7 = { "ù", "&ugrave;" };
    String[] arrayOfString8 = { "ý", "&yacute;" };
    ISO8859_1_ESCAPE = new String[][] { { " ", "&nbsp;" }, { "¡", "&iexcl;" }, { "¢", "&cent;" }, { "£", "&pound;" }, { "¤", "&curren;" }, { "¥", "&yen;" }, { "¦", "&brvbar;" }, { "§", "&sect;" }, { "¨", "&uml;" }, { "©", "&copy;" }, { "ª", "&ordf;" }, { "«", "&laquo;" }, { "¬", "&not;" }, { "­", "&shy;" }, { "®", "&reg;" }, { "¯", "&macr;" }, { "°", "&deg;" }, { "±", "&plusmn;" }, { "²", "&sup2;" }, { "³", "&sup3;" }, { "´", "&acute;" }, { "µ", "&micro;" }, arrayOfString1, { "·", "&middot;" }, { "¸", "&cedil;" }, { "¹", "&sup1;" }, { "º", "&ordm;" }, { "»", "&raquo;" }, arrayOfString2, { "½", "&frac12;" }, { "¾", "&frac34;" }, arrayOfString3, { "À", "&Agrave;" }, { "Á", "&Aacute;" }, { "Â", "&Acirc;" }, { "Ã", "&Atilde;" }, { "Ä", "&Auml;" }, { "Å", "&Aring;" }, { "Æ", "&AElig;" }, { "Ç", "&Ccedil;" }, { "È", "&Egrave;" }, { "É", "&Eacute;" }, { "Ê", "&Ecirc;" }, { "Ë", "&Euml;" }, { "Ì", "&Igrave;" }, { "Í", "&Iacute;" }, { "Î", "&Icirc;" }, { "Ï", "&Iuml;" }, { "Ð", "&ETH;" }, { "Ñ", "&Ntilde;" }, { "Ò", "&Ograve;" }, { "Ó", "&Oacute;" }, { "Ô", "&Ocirc;" }, { "Õ", "&Otilde;" }, { "Ö", "&Ouml;" }, { "×", "&times;" }, { "Ø", "&Oslash;" }, { "Ù", "&Ugrave;" }, { "Ú", "&Uacute;" }, { "Û", "&Ucirc;" }, arrayOfString4, { "Ý", "&Yacute;" }, { "Þ", "&THORN;" }, { "ß", "&szlig;" }, { "à", "&agrave;" }, { "á", "&aacute;" }, { "â", "&acirc;" }, { "ã", "&atilde;" }, { "ä", "&auml;" }, { "å", "&aring;" }, { "æ", "&aelig;" }, { "ç", "&ccedil;" }, { "è", "&egrave;" }, { "é", "&eacute;" }, { "ê", "&ecirc;" }, { "ë", "&euml;" }, { "ì", "&igrave;" }, { "í", "&iacute;" }, { "î", "&icirc;" }, { "ï", "&iuml;" }, { "ð", "&eth;" }, { "ñ", "&ntilde;" }, { "ò", "&ograve;" }, { "ó", "&oacute;" }, arrayOfString5, { "õ", "&otilde;" }, { "ö", "&ouml;" }, arrayOfString6, { "ø", "&oslash;" }, arrayOfString7, { "ú", "&uacute;" }, { "û", "&ucirc;" }, { "ü", "&uuml;" }, arrayOfString8, { "þ", "&thorn;" }, { "ÿ", "&yuml;" } };
    ISO8859_1_UNESCAPE = invert(ISO8859_1_ESCAPE);
    arrayOfString1 = new String[] { "Β", "&Beta;" };
    arrayOfString2 = new String[] { "Η", "&Eta;" };
    arrayOfString3 = new String[] { "Ρ", "&Rho;" };
    arrayOfString4 = new String[] { "Σ", "&Sigma;" };
    arrayOfString5 = new String[] { "Ω", "&Omega;" };
    arrayOfString6 = new String[] { "ε", "&epsilon;" };
    arrayOfString7 = new String[] { "λ", "&lambda;" };
    arrayOfString8 = new String[] { "μ", "&mu;" };
    String[] arrayOfString9 = { "ο", "&omicron;" };
    String[] arrayOfString10 = { "π", "&pi;" };
    String[] arrayOfString11 = { "υ", "&upsilon;" };
    String[] arrayOfString12 = { "χ", "&chi;" };
    String[] arrayOfString13 = { "ω", "&omega;" };
    String[] arrayOfString14 = { "•", "&bull;" };
    String[] arrayOfString15 = { "…", "&hellip;" };
    String[] arrayOfString16 = { "′", "&prime;" };
    String[] arrayOfString17 = { "‾", "&oline;" };
    String[] arrayOfString18 = { "ℜ", "&real;" };
    String[] arrayOfString19 = { "ℵ", "&alefsym;" };
    String[] arrayOfString20 = { "⇒", "&rArr;" };
    String[] arrayOfString21 = { "∅", "&empty;" };
    String[] arrayOfString22 = { "∉", "&notin;" };
    String[] arrayOfString23 = { "∝", "&prop;" };
    String[] arrayOfString24 = { "∠", "&ang;" };
    String[] arrayOfString25 = { "∩", "&cap;" };
    String[] arrayOfString26 = { "∼", "&sim;" };
    String[] arrayOfString27 = { "≅", "&cong;" };
    String[] arrayOfString28 = { "≡", "&equiv;" };
    String[] arrayOfString29 = { "⊗", "&otimes;" };
    String[] arrayOfString30 = { "⋅", "&sdot;" };
    String[] arrayOfString31 = { "⌉", "&rceil;" };
    String[] arrayOfString32 = { "⌋", "&rfloor;" };
    String[] arrayOfString33 = { "◊", "&loz;" };
    String[] arrayOfString34 = { "♣", "&clubs;" };
    String[] arrayOfString35 = { "Œ", "&OElig;" };
    String[] arrayOfString36 = { "Š", "&Scaron;" };
    String[] arrayOfString37 = { "š", "&scaron;" };
    String[] arrayOfString38 = { "‌", "&zwnj;" };
    String[] arrayOfString39 = { "‡", "&Dagger;" };
    HTML40_EXTENDED_ESCAPE = new String[][] { { "ƒ", "&fnof;" }, { "Α", "&Alpha;" }, arrayOfString1, { "Γ", "&Gamma;" }, { "Δ", "&Delta;" }, { "Ε", "&Epsilon;" }, { "Ζ", "&Zeta;" }, arrayOfString2, { "Θ", "&Theta;" }, { "Ι", "&Iota;" }, { "Κ", "&Kappa;" }, { "Λ", "&Lambda;" }, { "Μ", "&Mu;" }, { "Ν", "&Nu;" }, { "Ξ", "&Xi;" }, { "Ο", "&Omicron;" }, { "Π", "&Pi;" }, arrayOfString3, arrayOfString4, { "Τ", "&Tau;" }, { "Υ", "&Upsilon;" }, { "Φ", "&Phi;" }, { "Χ", "&Chi;" }, { "Ψ", "&Psi;" }, arrayOfString5, { "α", "&alpha;" }, { "β", "&beta;" }, { "γ", "&gamma;" }, { "δ", "&delta;" }, arrayOfString6, { "ζ", "&zeta;" }, { "η", "&eta;" }, { "θ", "&theta;" }, { "ι", "&iota;" }, { "κ", "&kappa;" }, arrayOfString7, arrayOfString8, { "ν", "&nu;" }, { "ξ", "&xi;" }, arrayOfString9, arrayOfString10, { "ρ", "&rho;" }, { "ς", "&sigmaf;" }, { "σ", "&sigma;" }, { "τ", "&tau;" }, arrayOfString11, { "φ", "&phi;" }, arrayOfString12, { "ψ", "&psi;" }, arrayOfString13, { "ϑ", "&thetasym;" }, { "ϒ", "&upsih;" }, { "ϖ", "&piv;" }, arrayOfString14, arrayOfString15, arrayOfString16, { "″", "&Prime;" }, arrayOfString17, { "⁄", "&frasl;" }, { "℘", "&weierp;" }, { "ℑ", "&image;" }, arrayOfString18, { "™", "&trade;" }, arrayOfString19, { "←", "&larr;" }, { "↑", "&uarr;" }, { "→", "&rarr;" }, { "↓", "&darr;" }, { "↔", "&harr;" }, { "↵", "&crarr;" }, { "⇐", "&lArr;" }, { "⇑", "&uArr;" }, arrayOfString20, { "⇓", "&dArr;" }, { "⇔", "&hArr;" }, { "∀", "&forall;" }, { "∂", "&part;" }, { "∃", "&exist;" }, arrayOfString21, { "∇", "&nabla;" }, { "∈", "&isin;" }, arrayOfString22, { "∋", "&ni;" }, { "∏", "&prod;" }, { "∑", "&sum;" }, { "−", "&minus;" }, { "∗", "&lowast;" }, { "√", "&radic;" }, arrayOfString23, { "∞", "&infin;" }, arrayOfString24, { "∧", "&and;" }, { "∨", "&or;" }, arrayOfString25, { "∪", "&cup;" }, { "∫", "&int;" }, { "∴", "&there4;" }, arrayOfString26, arrayOfString27, { "≈", "&asymp;" }, { "≠", "&ne;" }, arrayOfString28, { "≤", "&le;" }, { "≥", "&ge;" }, { "⊂", "&sub;" }, { "⊃", "&sup;" }, { "⊆", "&sube;" }, { "⊇", "&supe;" }, { "⊕", "&oplus;" }, arrayOfString29, { "⊥", "&perp;" }, arrayOfString30, { "⌈", "&lceil;" }, arrayOfString31, { "⌊", "&lfloor;" }, arrayOfString32, { "〈", "&lang;" }, { "〉", "&rang;" }, arrayOfString33, { "♠", "&spades;" }, arrayOfString34, { "♥", "&hearts;" }, { "♦", "&diams;" }, arrayOfString35, { "œ", "&oelig;" }, arrayOfString36, arrayOfString37, { "Ÿ", "&Yuml;" }, { "ˆ", "&circ;" }, { "˜", "&tilde;" }, { " ", "&ensp;" }, { " ", "&emsp;" }, { " ", "&thinsp;" }, arrayOfString38, { "‍", "&zwj;" }, { "‎", "&lrm;" }, { "‏", "&rlm;" }, { "–", "&ndash;" }, { "—", "&mdash;" }, { "‘", "&lsquo;" }, { "’", "&rsquo;" }, { "‚", "&sbquo;" }, { "“", "&ldquo;" }, { "”", "&rdquo;" }, { "„", "&bdquo;" }, { "†", "&dagger;" }, arrayOfString39, { "‰", "&permil;" }, { "‹", "&lsaquo;" }, { "›", "&rsaquo;" }, { "€", "&euro;" } };
    HTML40_EXTENDED_UNESCAPE = invert(HTML40_EXTENDED_ESCAPE);
    arrayOfString1 = new String[] { "&", "&amp;" };
    arrayOfString2 = new String[] { ">", "&gt;" };
    BASIC_ESCAPE = new String[][] { { "\"", "&quot;" }, arrayOfString1, { "<", "&lt;" }, arrayOfString2 };
    BASIC_UNESCAPE = invert(BASIC_ESCAPE);
    APOS_ESCAPE = new String[][] { { "'", "&apos;" } };
    APOS_UNESCAPE = invert(APOS_ESCAPE);
    arrayOfString1 = new String[] { "\f", "\\f" };
    JAVA_CTRL_CHARS_ESCAPE = new String[][] { { "\b", "\\b" }, { "\n", "\\n" }, { "\t", "\\t" }, arrayOfString1, { "\r", "\\r" } };
  }
  
  public static String[][] APOS_ESCAPE()
  {
    return (String[][])APOS_ESCAPE.clone();
  }
  
  public static String[][] APOS_UNESCAPE()
  {
    return (String[][])APOS_UNESCAPE.clone();
  }
  
  public static String[][] BASIC_ESCAPE()
  {
    return (String[][])BASIC_ESCAPE.clone();
  }
  
  public static String[][] BASIC_UNESCAPE()
  {
    return (String[][])BASIC_UNESCAPE.clone();
  }
  
  public static String[][] HTML40_EXTENDED_ESCAPE()
  {
    return (String[][])HTML40_EXTENDED_ESCAPE.clone();
  }
  
  public static String[][] HTML40_EXTENDED_UNESCAPE()
  {
    return (String[][])HTML40_EXTENDED_UNESCAPE.clone();
  }
  
  public static String[][] ISO8859_1_ESCAPE()
  {
    return (String[][])ISO8859_1_ESCAPE.clone();
  }
  
  public static String[][] ISO8859_1_UNESCAPE()
  {
    return (String[][])ISO8859_1_UNESCAPE.clone();
  }
  
  public static String[][] JAVA_CTRL_CHARS_ESCAPE()
  {
    return (String[][])JAVA_CTRL_CHARS_ESCAPE.clone();
  }
  
  public static String[][] JAVA_CTRL_CHARS_UNESCAPE()
  {
    return (String[][])JAVA_CTRL_CHARS_UNESCAPE.clone();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.translate.EntityArrays
 * JD-Core Version:    0.7.0.1
 */