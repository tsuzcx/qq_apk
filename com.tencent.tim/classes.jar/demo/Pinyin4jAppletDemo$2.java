package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

final class Pinyin4jAppletDemo$2
  implements ActionListener
{
  private final Pinyin4jAppletDemo this$0;
  
  Pinyin4jAppletDemo$2(Pinyin4jAppletDemo paramPinyin4jAppletDemo)
  {
    this.this$0 = paramPinyin4jAppletDemo;
  }
  
  private String concatPinyinStringArray(String[] paramArrayOfString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        localStringBuffer.append(paramArrayOfString[i]);
        localStringBuffer.append(System.getProperty("line.separator"));
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  private void updateFormattedTextField(char paramChar, String paramString1, String paramString2, String paramString3)
  {
    HanyuPinyinOutputFormat localHanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
    if (this.this$0.toneTypes[0] == paramString1)
    {
      localHanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
      if (this.this$0.vCharTypes[0] != paramString2) {
        break label150;
      }
      localHanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
      label51:
      if (this.this$0.caseTypes[0] != paramString3) {
        break label198;
      }
      localHanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    }
    for (;;)
    {
      paramString1 = null;
      try
      {
        paramString2 = PinyinHelper.toHanyuPinyinStringArray(paramChar, localHanyuPinyinOutputFormat);
        paramString1 = paramString2;
      }
      catch (BadHanyuPinyinOutputFormatCombination paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
      paramString1 = concatPinyinStringArray(paramString1);
      Pinyin4jAppletDemo.access$1000(this.this$0).setText(paramString1);
      return;
      if (this.this$0.toneTypes[1] == paramString1)
      {
        localHanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        break;
      }
      if (this.this$0.toneTypes[2] != paramString1) {
        break;
      }
      localHanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
      break;
      label150:
      if (this.this$0.vCharTypes[1] == paramString2)
      {
        localHanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        break label51;
      }
      if (this.this$0.vCharTypes[2] != paramString2) {
        break label51;
      }
      localHanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
      break label51;
      label198:
      if (this.this$0.caseTypes[1] == paramString3) {
        localHanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
      }
    }
  }
  
  private void updateUnformattedTextField(char paramChar)
  {
    Pinyin4jAppletDemo.access$400(this.this$0).setText(concatPinyinStringArray(PinyinHelper.toHanyuPinyinStringArray(paramChar)));
    Pinyin4jAppletDemo.access$500(this.this$0).setText(concatPinyinStringArray(PinyinHelper.toTongyongPinyinStringArray(paramChar)));
    Pinyin4jAppletDemo.access$600(this.this$0).setText(concatPinyinStringArray(PinyinHelper.toWadeGilesPinyinStringArray(paramChar)));
    Pinyin4jAppletDemo.access$700(this.this$0).setText(concatPinyinStringArray(PinyinHelper.toMPS2PinyinStringArray(paramChar)));
    Pinyin4jAppletDemo.access$800(this.this$0).setText(concatPinyinStringArray(PinyinHelper.toYalePinyinStringArray(paramChar)));
    Pinyin4jAppletDemo.access$900(this.this$0).setText(concatPinyinStringArray(PinyinHelper.toGwoyeuRomatzyhStringArray(paramChar)));
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    char c = Pinyin4jAppletDemo.access$000(this.this$0).charAt(0);
    updateUnformattedTextField(c);
    updateFormattedTextField(c, (String)Pinyin4jAppletDemo.access$100(this.this$0).getSelectedItem(), (String)Pinyin4jAppletDemo.access$200(this.this$0).getSelectedItem(), (String)Pinyin4jAppletDemo.access$300(this.this$0).getSelectedItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     demo.Pinyin4jAppletDemo.2
 * JD-Core Version:    0.7.0.1
 */