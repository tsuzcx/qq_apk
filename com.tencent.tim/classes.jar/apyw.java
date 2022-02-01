import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.widget.Button;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;

public class apyw
  extends apsy
{
  public apyw(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void d(SparseArray<apsz.c> paramSparseArray)
  {
    int j = 0;
    this.this$0.dK = paramSparseArray;
    Object localObject = (apsz.c)this.this$0.dK.get(this.this$0.dXY);
    if (localObject != null)
    {
      paramSparseArray = ((apsz.c)localObject).wording;
      if (localObject == null) {
        break label120;
      }
      localObject = ((apsz.c)localObject).cre;
      label55:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label126;
      }
      j = paramSparseArray.indexOf((String)localObject);
    }
    label120:
    label126:
    for (int i = ((String)localObject).length() + j;; i = 0)
    {
      paramSparseArray = new SpannableString(paramSparseArray);
      paramSparseArray.setSpan(new StrikethroughSpan(), j, i, 18);
      this.this$0.cd.setText(paramSparseArray);
      return;
      paramSparseArray = "30金豆秀一下";
      break;
      localObject = null;
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyw
 * JD-Core Version:    0.7.0.1
 */