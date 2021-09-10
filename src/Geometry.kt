class Geometry {



    class Line {
        private var slope: Double = 0.0
        private var intercept: Double = 0.0

        constructor(slope: Double, intercept: Double) {
            this.slope = slope
            this.intercept = intercept

        }
    }

    class Circle {
        private var radius: Double = 1.0
        private var centre: Pair<Double, Double> = Pair(0.0, 0.0)

        constructor(radius: Double, centre: Pair<Double, Double>) {
            this.radius = radius
            this.centre = centre
        }
    }

    fun getInterceptions(shape1: Geometry, shape2: Geometry) {

    }

    fun findArea() {

    }
}