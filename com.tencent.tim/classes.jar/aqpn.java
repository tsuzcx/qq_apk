import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.data.EmoticonPackage;

final class aqpn
  implements ajdq<EmoticonPackage>
{
  aqpn(int paramInt1, int paramInt2, EditText paramEditText) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    int j = 0;
    char[] arrayOfChar1 = afgc.b(this.cTe, this.cTf);
    char[] arrayOfChar2 = new char[7];
    arrayOfChar2[0] = '<';
    arrayOfChar2[1] = '$';
    arrayOfChar2[2] = arrayOfChar1[0];
    arrayOfChar2[3] = arrayOfChar1[1];
    arrayOfChar2[4] = arrayOfChar1[2];
    arrayOfChar2[5] = arrayOfChar1[3];
    arrayOfChar2[6] = '>';
    int i = j;
    if (paramEmoticonPackage != null)
    {
      i = j;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        arrayOfChar2[1] = 'ǿ';
        i = j;
      }
    }
    while (i < arrayOfChar2.length)
    {
      if (arrayOfChar2[i] == 0) {
        arrayOfChar2[i] = 'Ā';
      }
      i += 1;
    }
    i = this.bd.getSelectionStart();
    j = this.bd.getSelectionEnd();
    this.bd.getEditableText().replace(i, j, String.valueOf(arrayOfChar2));
    this.bd.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpn
 * JD-Core Version:    0.7.0.1
 */