package moai.core.watcher;

import rx.subjects.AsyncSubject;
import rx.subjects.Subject;

 enum Watchers$Subjects$3
{
  Watchers$Subjects$3()
  {
    super(str, i, null);
  }
  
  Subject<Watchers.Context, Watchers.Context> create()
  {
    return AsyncSubject.create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.Watchers.Subjects.3
 * JD-Core Version:    0.7.0.1
 */