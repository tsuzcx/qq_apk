package dov.com.qq.im.aeeditor.module.text;

import axnr;
import org.libpag.PAGFile;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class AEEditorTextEditDialog$4
  implements Runnable
{
  public AEEditorTextEditDialog$4(axnr paramaxnr, PAGFile paramPAGFile, PAGText paramPAGText) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgLibpagPAGFile != axnr.a(this.this$0).getFile()) {
      axnr.a(this.this$0).setFile(this.jdField_a_of_type_OrgLibpagPAGFile);
    }
    axnr.a(this.this$0).setTextData(0, this.jdField_a_of_type_OrgLibpagPAGText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.4
 * JD-Core Version:    0.7.0.1
 */