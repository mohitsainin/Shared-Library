def call(String repositoryUrl, String branch = 'main') {
    // Perform a clean checkout if the repository is already present
    dir('workspace') {
        if (fileExists('.git')) {
            echo "Repository already cloned. Pulling the latest changes."
            sh "git checkout ${branch}"
            sh "git pull origin ${branch}"
        } else {
            echo "Cloning repository from ${repositoryUrl} and checking out branch ${branch}"
            sh "git clone ${repositoryUrl} --branch ${branch} --single-branch ."
        }
    }
}
