def call(String subject, String body, String reportDir, String reportFile, String recipients = 'it.mohitsaini@gmail.com') {
    emailext(
        subject: subject,
        body: body,
        attachmentsPattern: "${reportDir}/${reportFile}",
        to: recipients
    )
}
