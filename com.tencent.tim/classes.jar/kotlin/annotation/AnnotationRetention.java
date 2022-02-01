package kotlin.annotation;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/annotation/AnnotationRetention;", "", "(Ljava/lang/String;I)V", "SOURCE", "BINARY", "RUNTIME", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum AnnotationRetention
{
  static
  {
    AnnotationRetention localAnnotationRetention1 = new AnnotationRetention("SOURCE", 0);
    SOURCE = localAnnotationRetention1;
    AnnotationRetention localAnnotationRetention2 = new AnnotationRetention("BINARY", 1);
    BINARY = localAnnotationRetention2;
    AnnotationRetention localAnnotationRetention3 = new AnnotationRetention("RUNTIME", 2);
    RUNTIME = localAnnotationRetention3;
    $VALUES = new AnnotationRetention[] { localAnnotationRetention1, localAnnotationRetention2, localAnnotationRetention3 };
  }
  
  private AnnotationRetention() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.annotation.AnnotationRetention
 * JD-Core Version:    0.7.0.1
 */