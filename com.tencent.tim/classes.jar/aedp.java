import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aedp
{
  private aeaz mColorNoteCurd;
  private View mContentView;
  private Context mContext;
  private aebf mServiceInfo;
  
  public aedp(Context paramContext)
  {
    this.mContext = paramContext;
    this.mColorNoteCurd = new aeaz();
    this.mColorNoteCurd.setOnColorNoteCurdListener(new aeaz.b());
  }
  
  private ColorNote generateColorNote()
  {
    if (this.mServiceInfo != null) {
      return this.mServiceInfo.getColorNote();
    }
    return null;
  }
  
  public aebf c()
  {
    return this.mServiceInfo;
  }
  
  public boolean canAddColorNote()
  {
    return this.mColorNoteCurd.canAddColorNote();
  }
  
  public void deleteColorNote()
  {
    if (this.mServiceInfo != null)
    {
      ColorNote localColorNote = this.mServiceInfo.getColorNote();
      if (localColorNote != null)
      {
        this.mColorNoteCurd.deleteColorNote(localColorNote.getServiceType(), localColorNote.getSubType());
        anot.a(null, "dc00898", "", "", "0X800A748", "0X800A748", aeax.gT(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public ColorNote getColorNote()
  {
    if (this.mServiceInfo != null) {
      return this.mServiceInfo.getColorNote();
    }
    return null;
  }
  
  public void insertColorNote()
  {
    ColorNote localColorNote = generateColorNote();
    if (localColorNote != null)
    {
      this.mColorNoteCurd.cm(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        anot.a(null, "dc00898", "", "", "0X800A743", "0X800A743", aeax.gT(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean isColorNoteExist()
  {
    if (this.mServiceInfo != null)
    {
      ColorNote localColorNote = this.mServiceInfo.getColorNote();
      if (localColorNote != null) {
        return this.mColorNoteCurd.u(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void j(ColorNote paramColorNote)
  {
    this.mColorNoteCurd.j(paramColorNote);
  }
  
  public void onCannotAdd()
  {
    aebs.ed(this.mContext);
    anot.a(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public void setOnColorNoteCurdListener(aeaz.b paramb)
  {
    this.mColorNoteCurd.setOnColorNoteCurdListener(paramb);
  }
  
  public void setServiceInfo(aebf paramaebf)
  {
    this.mServiceInfo = paramaebf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedp
 * JD-Core Version:    0.7.0.1
 */