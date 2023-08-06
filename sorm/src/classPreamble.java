public @interface classPreamble {

	String author();
	String date();
	String currentRevision() default "1.0.0";
	String lastModified() default "N/A";
	String lastModifiedBy() default "Sean Kim";

	// String[] reviewers();
}
