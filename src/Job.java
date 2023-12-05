public enum Job {
    ARCHER,
    KNIGHT,
    THIEF;

    public static Job fromString(String input) {
        for (Job job : Job.values()) {
            if (job.name().equalsIgnoreCase(input)) {
                return job;
            }
        }
        throw new IllegalArgumentException("Invalid job: " + input);
    }
}