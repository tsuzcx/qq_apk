import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aecz
{
  private aecz.a a;
  private int mType;
  private List<ColorNote> yH;
  
  private void b(ColorNote paramColorNote, int paramInt)
  {
    anot.a(null, "dc00898", "", "", "0X800AA80", "0X800AA80", aebs.gW(this.mType), 0, String.valueOf(paramInt), "", "", "");
    paramInt = paramColorNote.getServiceType();
    if (paramInt == 17039360)
    {
      String str2 = "0X800AA82";
      paramInt = 0;
      int i = paramInt;
      String str1 = str2;
      if (!TextUtils.isEmpty(paramColorNote.getSubType()))
      {
        i = paramInt;
        str1 = str2;
        if (ahbr.de(paramColorNote.getSubType()) == 4)
        {
          str1 = "0X800AA83";
          i = 1;
        }
      }
      switch (ahav.getFileType(paramColorNote.getMainTitle()))
      {
      case 5: 
      case 8: 
      default: 
        paramInt = 6;
        if (i != 0) {
          paramInt = 7;
        }
        anot.a(null, "dc00898", "", "", str1, str1, paramInt, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      paramInt = 4;
      break;
      paramInt = 5;
      break;
      if (paramInt == 17104896)
      {
        paramColorNote = paramColorNote.getSubType().split("-");
        paramInt = 0;
        if (paramColorNote.length > 1) {
          paramInt = Integer.parseInt(paramColorNote[1]);
        }
        anot.a(null, "dc00898", "", "", "0X800AA83", "0X800AA83", paramInt, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 16908288);
    if (paramColorNote.getReserve() != null) {}
    for (;;)
    {
      try
      {
        bool = new JSONObject(new String(paramColorNote.getReserve())).getBoolean("h5_type_read_in_joy");
        if (this.mType != 17104896) {
          break;
        }
        if (!bool) {
          break label350;
        }
        paramInt = 9;
        anot.a(null, "dc00898", "", "", "0X800AA83", "0X800AA83", paramInt, 0, "", "", "", "");
        return;
      }
      catch (JSONException paramColorNote)
      {
        QLog.e("BaseSectionAdapter", 1, paramColorNote, new Object[0]);
      }
      boolean bool = false;
      continue;
      label350:
      paramInt = 8;
    }
  }
  
  public void a(aecz.a parama)
  {
    this.a = parama;
  }
  
  public List<HistoryFormItem> l(Context paramContext)
  {
    Object localObject = new aedi();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.yH.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((aedi)localObject).a(paramContext, (ColorNote)localIterator.next()));
    }
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      localObject = (HistoryFormItem)paramContext.next();
      ((HistoryFormItem)localObject).setIndex(i);
      ((HistoryFormItem)localObject).setItemOnClickListener(new aeda(this, (HistoryFormItem)localObject));
      ((HistoryFormItem)localObject).setOnIconClickListener(new aedb(this, (HistoryFormItem)localObject));
      i += 1;
    }
    return localArrayList;
  }
  
  public void setData(List<ColorNote> paramList, int paramInt)
  {
    this.mType = paramInt;
    this.yH = paramList;
    this.a.cVL();
  }
  
  public static abstract interface a
  {
    public abstract void cVL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecz
 * JD-Core Version:    0.7.0.1
 */