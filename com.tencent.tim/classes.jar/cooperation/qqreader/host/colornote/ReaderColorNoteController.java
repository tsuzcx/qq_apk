package cooperation.qqreader.host.colornote;

import aeay;
import android.content.Context;
import android.content.ContextWrapper;
import avod;

public class ReaderColorNoteController
{
  private aeay a;
  
  public ReaderColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = new aeay(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static void setCustomNightMode(Context paramContext, boolean paramBoolean)
  {
    aeay.setCustomNightMode(paramContext, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.a.addHistoryNote();
  }
  
  public void addToRecentNote()
  {
    this.a.addToRecentNote();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = avod.getActivity(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.a.attachToActivity(paramContextWrapper);
    }
  }
  
  public boolean canAddColorNote()
  {
    return this.a.canAddColorNote();
  }
  
  public void deleteColorNote()
  {
    this.a.deleteColorNote();
  }
  
  public void exitAnimation()
  {
    this.a.exitAnimation();
  }
  
  public void insertColorNote()
  {
    this.a.insertColorNote();
  }
  
  public boolean isColorNoteExist()
  {
    return this.a.isColorNoteExist();
  }
  
  public void onCannotAdd()
  {
    this.a.onCannotAdd();
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  public void onPause()
  {
    this.a.onPause();
  }
  
  public void onResume()
  {
    if (this.a.shouldDisplayColorNote()) {
      this.a.onResume();
    }
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinishCallback paramOnColorNoteAnimFinishCallback)
  {
    this.a.a(new ReaderColorNoteController.1(this, paramOnColorNoteAnimFinishCallback));
  }
  
  public void setReaderServiceInfo(IReaderServiceInfo paramIReaderServiceInfo)
  {
    this.a.setServiceInfo(new ReaderColorNoteController.2(this, paramIReaderServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.a.shouldDisplayColorNote();
  }
  
  public void updateColorNote(ReaderColorNote paramReaderColorNote)
  {
    this.a.j(paramReaderColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteController
 * JD-Core Version:    0.7.0.1
 */