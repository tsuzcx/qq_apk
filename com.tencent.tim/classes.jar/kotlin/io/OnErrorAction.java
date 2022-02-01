package kotlin.io;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/OnErrorAction;", "", "(Ljava/lang/String;I)V", "SKIP", "TERMINATE", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum OnErrorAction
{
  static
  {
    OnErrorAction localOnErrorAction1 = new OnErrorAction("SKIP", 0);
    SKIP = localOnErrorAction1;
    OnErrorAction localOnErrorAction2 = new OnErrorAction("TERMINATE", 1);
    TERMINATE = localOnErrorAction2;
    $VALUES = new OnErrorAction[] { localOnErrorAction1, localOnErrorAction2 };
  }
  
  private OnErrorAction() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.io.OnErrorAction
 * JD-Core Version:    0.7.0.1
 */