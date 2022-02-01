package moai.core.watcher;

import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

 enum Watchers$Subjects$4
{
  Watchers$Subjects$4()
  {
    super(str, i, null);
  }
  
  Subject<Watchers.Context, Watchers.Context> create()
  {
    return ReplaySubject.create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.Watchers.Subjects.4
 * JD-Core Version:    0.7.0.1
 */