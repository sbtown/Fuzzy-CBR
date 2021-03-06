# Fuzzy-CBR
This was part of my final year project in which I was looking into the accuracy of a Case-Based Reasoning(CBR) Fuzzy-Logic hybrid (Fuzzy-CBR) that I developed. 

# Software and Data Sets

## [Apache POI](https://poi.apache.org/)
Apart of the Apache Software Foundation, this will enable you to use an excel document as a personal database. POI 4.1.2 was used during development. 

## [Data Set](https://archive.ics.uci.edu/ml/datasets/breast+cancer+wisconsin+(original)) 
The data set provided by Dr. WIlliam H. Wolberg and the University of Wisconsin Hospitals. Data set provides information on breast cancer and the class diagnosis being either benign(2) or malignant(4). There is 699 instances with 10 attributtes:

### Attribute Information:
1. Sample code number: id number
2. Clump Thickness: 1 - 10
3. Uniformity of Cell Size: 1 - 10
4. Uniformity of Cell Shape: 1 - 10
5. Marginal Adhesion: 1 - 10
6. Single Epithelial Cell Size: 1 - 10
7. Bare Nuclei: 1 - 10
8. Bland Chromatin: 1 - 10
9. Normal Nucleoli: 1 - 10
10. Mitoses: 1 - 10
11. Class: (2 for benign, 4 for malignant)


## Testing and Results
### Testing
Testing was done using a 30/70 split. The test files have been added to the repository and available [here](https://github.com/sbtown/Fuzzy-CBR/tree/master/Fuzzy-CBR/Testing)

### Results
The results show a slightly higher accuracy in Fuzzy-CBR when taking 3 and 5 Nearest Neighbor(NN) and data has been left ambiguous.

![alt text](ImagesAndDiagrams/accuracy.PNG "Accuracy")
##### *The average accuracy between CBR and Fuzzy-CBR using 3 weighting methods.* 
***
![alt text](ImagesAndDiagrams/tableAccuracy.PNG "Table Accuracy")
##### *Table of Accuracy Results*
***
![alt text](ImagesAndDiagrams/likelihood.PNG "Likelihood Results")
##### *The average likelihood of giving a correct diagnosis.* 
***
![alt text](ImagesAndDiagrams/tableLikelihood.PNG "Table Liklihood")
##### Table of Lilelihood Results 
***
### Clustering

![alt text](ImagesAndDiagrams/clusterAccuracy.PNG "Cluster Accuracy")
##### *The average accuracy using 3-NN and 5-NN*
***
![alt text](ImagesAndDiagrams/tableCluster.PNG "Table Cluster")
##### *Table of Clustering Retrieval Accuracy*

